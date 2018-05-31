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

import java.util.List;


public class InputController implements InputProcessor {
    private Camera camera;
    private StepCursor cursor;
    private List<Coo> currentSteps;
    private Hero hero;
    private WorldTxLibrary txLibrary;

    public InputController(Camera camera, StepCursor cursor, Hero hero, WorldTxLibrary txLibrary) {
        this.camera = camera;
        this.cursor = cursor;
        this.hero = hero;
        this.txLibrary = txLibrary;
    }

    public boolean touchUp(Coo coo) {
        if (WorldObjectUtil.canMove(coo, txLibrary)) {
            if (cursor != null && cursor.getCoo() != null && cursor.getCoo().equals(coo)) {
                // повторное нажатие на курсор - то есть передвигаем туда героя + чистим степы и сам курсор
//                MoveHelper.move(hero, currentSteps, objectLayer);
                hero.addWalkingSteps(currentSteps);
                WorldObjectUtil.clearCell(txLibrary.getLayer(WorldLayerType.CURSOR), cursor);
            } else {
                WorldObjectUtil.clearCells(txLibrary.getLayer(WorldLayerType.OBJECTS), currentSteps);
                MoveHelper.move(cursor, coo, txLibrary.getLayer(WorldLayerType.CURSOR));

                long start = System.currentTimeMillis();
                Gdx.app.log("Search path start - ", String.valueOf(start));
                currentSteps = SearchPathUtil.get().search(txLibrary.getLayer(WorldLayerType.OBJECTS), hero.getCoo(), coo);
                Gdx.app.log("Search path finish - ", String.valueOf(System.currentTimeMillis() - start));
                WorldObjectUtil.buildSteps(currentSteps, hero.getMaxStepCount(), txLibrary);
            }
        }
        return true;
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
        return touchUp(coo);
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
