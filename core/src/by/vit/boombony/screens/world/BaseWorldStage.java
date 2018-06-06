package by.vit.boombony.screens.world;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.vit.boombony.gameobjects.DynamicWorldObject;
import by.vit.boombony.gameobjects.StepCursor;
import by.vit.boombony.gameworld.path.SearchPathUtil;
import by.vit.boombony.helpers.Const;
import by.vit.boombony.helpers.Coo;
import by.vit.boombony.helpers.CoordinateUtil;
import by.vit.boombony.helpers.MoveHelper;
import by.vit.boombony.screens.AbstractStage;

public abstract class BaseWorldStage extends AbstractStage<WorldTxLibrary> {
    private WorldScreen worldScreen;
    private Camera camera;
    private StepCursor cursor;
    private List<Coo> currentSteps = Collections.synchronizedList(new ArrayList<>());
    private OrthogonalTiledMapRenderer tiledMapRenderer;
    private int mapWidth = 0;
    private int mapHeight = 0;

    public BaseWorldStage(WorldScreen worldScreen, WorldTxLibrary txLibrary) {
        super(txLibrary);
        this.worldScreen = worldScreen;
    }

    public abstract DynamicWorldObject getHero();

    @Override
    public void init() {
        this.camera = worldScreen.getCamera();
        this.cursor = new StepCursor(txLibrary.txRegion("maps/activecell.png"));
        initTiledMapRenderer();
    }

    private void initTiledMapRenderer() {
        this.tiledMapRenderer = new OrthogonalTiledMapRenderer(txLibrary.getTiledMap(), worldScreen.getScreenManager().getGame().getBatch());
        this.mapWidth = WorldTxLibrary.GROUND_LAYER.getWidth() * Const.TILE_SIZE;
        this.mapHeight = WorldTxLibrary.GROUND_LAYER.getHeight() * Const.TILE_SIZE;
    }

    /**
     * Try to initial move the hero. If we can not move we return false just for transit action event.
     *
     * @param targetCoo coo
     * @return true if we handle event
     */
    private boolean heroInitMove(DynamicWorldObject targetObject, Coo targetCoo) {
        if (WorldObjectUtil.canMove(targetCoo, txLibrary)) {
            // if was init move and there are no any barriers at first we should stop targetObject
            targetObject.setCanMove(false);

            // if targetObject can move to target cursor
            if (goMove(targetCoo)) {
                // повторное нажатие на курсор - то есть передвигаем туда героя + чистим степы и сам курсор
                targetObject.addWalkingSteps(currentSteps);

                // now targetObject can move to target cell
                targetObject.setCanMove(true);

                // other way we should build path to target cursor
            } else {
                WorldObjectUtil.clearCells(WorldTxLibrary.OBJECTS_LAYER, currentSteps);
                currentSteps.clear();
                MoveHelper.move(cursor, targetCoo, WorldTxLibrary.CURSOR_LAYER);

                SearchPathUtil searchPathUtil = SearchPathUtil.get();
                if (!searchPathUtil.isSearchingInProgress()) {
                    currentSteps = searchPathUtil.search(WorldTxLibrary.OBJECTS_LAYER, targetObject.getCell().getCoo(), targetCoo);
                    WorldObjectUtil.drawSteps(currentSteps, txLibrary);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        CameraHelper.followCamera(camera, getHero(), this.mapWidth, this.mapHeight);

        if (tiledMapRenderer != null) {
            // these view responsible for render full size of map with width and height.
            // potentially it could be optimizated in future
            tiledMapRenderer.setView(camera.combined, 0, 0, this.mapWidth, this.mapHeight);
            tiledMapRenderer.render();
        }
    }

    private boolean goMove(Coo targetCoo) {
        return cursor != null && cursor.getCoo() != null && cursor.getCoo().equals(targetCoo);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        super.touchUp(screenX, screenY, pointer, button);
        int layerX = screenX + Float.valueOf(camera.position.x - camera.viewportWidth / 2).intValue();
        int layerY = Float.valueOf(camera.position.y - camera.viewportHeight / 2).intValue() + Float.valueOf(camera.viewportHeight - screenY).intValue();
        Coo coo = CoordinateUtil.getCellCenter(layerX, layerY);
        return heroInitMove(getHero(), coo);
    }
}
