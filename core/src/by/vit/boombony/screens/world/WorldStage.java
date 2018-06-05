package by.vit.boombony.screens.world;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.vit.boombony.Logger;
import by.vit.boombony.gameobjects.Hero;
import by.vit.boombony.gameobjects.Person;
import by.vit.boombony.gameobjects.StepCursor;
import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.gameworld.path.SearchPathUtil;
import by.vit.boombony.helpers.Const;
import by.vit.boombony.helpers.Coo;
import by.vit.boombony.helpers.CoordinateUtil;
import by.vit.boombony.helpers.MoveHelper;
import by.vit.boombony.screens.AbstractStage;

public class WorldStage extends AbstractStage<WorldTxLibrary> {
    private WorldScreen worldScreen;
    private Camera camera;
    private StepCursor cursor;
    private List<Coo> currentSteps = Collections.synchronizedList(new ArrayList<>());
    private Hero hero;
    private Person oldDukePerson;
    private OrthogonalTiledMapRenderer tiledMapRenderer;
    private int mapWidth = 0;
    private int mapHeight = 0;

    public WorldStage(WorldScreen worldScreen, WorldTxLibrary txLibrary) {
        super(txLibrary);
        this.worldScreen = worldScreen;
    }

    @Override
    public void init() {
        this.camera = worldScreen.getCamera();
        this.cursor = new StepCursor(txLibrary.txRegion("maps/activecell.png"));

        this.hero = new Hero(txLibrary.txRegion("maps/hero.png"));
        addActor(this.hero);
        MoveHelper.moveObject(hero.getCell(), 0, 0);

        oldDukePerson = new Person(txLibrary.txRegion("maps/old_duke.png"), WorldObjectType.NEUTRAL);
        addActor(this.oldDukePerson);
        MoveHelper.moveObject(oldDukePerson.getCell(), 3, 0);

        this.tiledMapRenderer = new OrthogonalTiledMapRenderer(txLibrary.getTiledMap(), worldScreen.getScreenManager().getGame().getBatch());
        this.mapWidth = WorldTxLibrary.GROUND_LAYER.getWidth() * Const.TILE_SIZE;
        this.mapHeight = WorldTxLibrary.GROUND_LAYER.getHeight() * Const.TILE_SIZE;
    }

    public boolean heroInitMove(Coo targetCoo) {
        if (WorldObjectUtil.canMove(targetCoo, txLibrary)) {
            // if was init move and there are no any barriers at first we should stop hero
            hero.setCanMove(false);

            // if hero can move to target cursor
            if (wantMove(targetCoo)) {
                // повторное нажатие на курсор - то есть передвигаем туда героя + чистим степы и сам курсор
                hero.addWalkingSteps(currentSteps);
//                currentSteps.clear();

                // clear target cell
                WorldObjectUtil.clearCell(WorldTxLibrary.CURSOR_LAYER, cursor);

                // now hero can move to target cell
                hero.setCanMove(true);

                // other way we should build path to target cursor
            } else {
                WorldObjectUtil.clearCells(WorldTxLibrary.OBJECTS_LAYER, currentSteps);
                currentSteps.clear();
                MoveHelper.move(cursor, targetCoo, WorldTxLibrary.CURSOR_LAYER);

                Logger.logWithMark("Search path");
                SearchPathUtil searchPathUtil = SearchPathUtil.get();
                if (!searchPathUtil.isSearchingInProgress()) {
                    currentSteps = searchPathUtil.search(WorldTxLibrary.OBJECTS_LAYER, hero.getCell().getCoo(), targetCoo);
                    Logger.logWithMark("Search path");
                    WorldObjectUtil.drawSteps(currentSteps, hero.getMaxStepCount(), txLibrary);
                } else {
                    Logger.log("Search path was skipped");
                }
            }
        }
        return true;
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        CameraHelper.followCamera(camera, hero, this.mapWidth, this.mapHeight);

        if (tiledMapRenderer != null) {
            // these view responsible for render full size of map with width and height.
            // potentially it could be optimizated in future
            tiledMapRenderer.setView(camera.combined, 0, 0, this.mapWidth, this.mapHeight);
            tiledMapRenderer.render();
        }
    }

    private boolean wantMove(Coo targetCoo) {
        return cursor != null && cursor.getCoo() != null && cursor.getCoo().equals(targetCoo);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        int layerX = screenX + Float.valueOf(camera.position.x - camera.viewportWidth / 2).intValue();
        int layerY = Float.valueOf(camera.position.y - camera.viewportHeight / 2).intValue() + Float.valueOf(camera.viewportHeight - screenY).intValue();
        Coo coo = CoordinateUtil.getCellCenter(layerX, layerY);
        return heroInitMove(coo);
    }
}
