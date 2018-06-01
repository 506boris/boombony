package by.vit.boombony.screens.world;

import by.vit.boombony.gameobjects.Hero;
import by.vit.boombony.gameobjects.StepCursor;
import by.vit.boombony.gameworld.WorldLayerType;
import by.vit.boombony.gameworld.path.SearchPathUtil;
import by.vit.boombony.helpers.Coo;
import by.vit.boombony.helpers.CoordinateUtil;
import by.vit.boombony.helpers.MoveHelper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Camera;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class InputController implements InputProcessor {
    private Camera camera;
    private StepCursor cursor;
    private List<Coo> currentSteps = Collections.synchronizedList(new ArrayList<>());
    private Hero hero;
    private WorldTxLibrary txLibrary;

    public InputController(Camera camera, StepCursor cursor, Hero hero, WorldTxLibrary txLibrary) {
        this.camera = camera;
        this.cursor = cursor;
        this.hero = hero;
        this.txLibrary = txLibrary;
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
                WorldObjectUtil.clearCell(txLibrary.getLayer(WorldLayerType.CURSOR), cursor);

                // now hero can move to target cell
                hero.setCanMove(true);

                // other way we should build path to target cursor
            } else {
                WorldObjectUtil.clearCells(txLibrary.getLayer(WorldLayerType.OBJECTS), currentSteps);
                currentSteps.clear();
                MoveHelper.move(cursor, targetCoo, txLibrary.getLayer(WorldLayerType.CURSOR));

                long start = System.currentTimeMillis();
                Gdx.app.log("Search path start - ", String.valueOf(start));
                currentSteps = SearchPathUtil.get().search(txLibrary.getLayer(WorldLayerType.OBJECTS), hero.getCoo(), targetCoo);
                Gdx.app.log("Search path finish - ", String.valueOf(System.currentTimeMillis() - start));
                WorldObjectUtil.drawSteps(currentSteps, hero.getMaxStepCount(), txLibrary);
            }
        }
        return true;
    }

    private boolean wantMove(Coo targetCoo) {
        return cursor != null && cursor.getCoo() != null && cursor.getCoo().equals(targetCoo);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        int layerX = screenX + Float.valueOf(camera.position.x - camera.viewportWidth / 2).intValue();
        int layerY = Float.valueOf(camera.position.y - camera.viewportHeight / 2).intValue() + Float.valueOf(camera.viewportHeight - screenY).intValue();
        Coo coo = CoordinateUtil.getCellCenter(layerX, layerY);
        return heroInitMove(coo);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
