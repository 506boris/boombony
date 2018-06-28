package by.vit.boombony.screens.world;

import by.vit.boombony.common.map.WorldTiledMap;
import by.vit.boombony.gameobjects.Cell;
import by.vit.boombony.gameobjects.Step;
import by.vit.boombony.gameobjects.WorldObject;
import by.vit.boombony.helpers.Coo;
import by.vit.boombony.texture.WorldTxLibrary;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.List;

public final class WorldObjectUtil {

    public static WorldObject tryCast(TiledMapTileLayer.Cell objectCell) {
        if (objectCell == null) {
            return null;
        }

        if (objectCell instanceof Cell) {
            return ((Cell) objectCell).getParent();
        }
        return null;
    }

    /**
     * Прорисовываем степы
     *
     * @param currentSteps список координат, где мы должны прорисовать степы
     */
    public static void drawSteps(List<Coo> currentSteps, int maxStepCount, WorldTxLibrary txLibrary) {
        // currentSteps первый и последний элемент не должны прорисосываться в виде степов так как это герой и курсор.
        // currentSteps - степы в списке расположены с target к hero
        for (int i = currentSteps.size() - 1; i >= 0; i--) {
            if (i == 0 || i == currentSteps.size() - 1) {
                continue;
            }
            Coo currentCoo = currentSteps.get(i);
            // если шаги выходят за максимальное колличество, которое имеет герой, то помечаем как out
            if (currentSteps.size() - (i + 1) <= maxStepCount) {
                WorldTiledMap.cursorLayer.setCell(currentCoo.x, currentCoo.y, new Step(txLibrary.txRegion("step.png"), currentCoo).getCell());
            } else {
                WorldTiledMap.cursorLayer.setCell(currentCoo.x, currentCoo.y, new Step(txLibrary.txRegion("step-out.png"), currentCoo).getCell());
            }
        }
    }

    /**
     * Прорисовываем степы
     *
     * @param currentSteps список координат, где мы должны прорисовать степы
     */
    public static void drawSteps(List<Coo> currentSteps, WorldTxLibrary txLibrary) {
        // currentSteps первый и последний элемент не должны прорисосываться в виде степов так как это герой и курсор.
        // currentSteps - степы в списке расположены с target к hero
        for (int i = currentSteps.size() - 1; i >= 0; i--) {
            if (i == 0 || i == currentSteps.size() - 1) {
                continue;
            }
            Coo currentCoo = currentSteps.get(i);
            // если шаги выходят за максимальное колличество, которое имеет герой, то помечаем как out
            WorldTiledMap.cursorLayer.setCell(currentCoo.x, currentCoo.y, new Step(txLibrary.txRegion("step.png"), currentCoo).getCell());
        }
    }
}
