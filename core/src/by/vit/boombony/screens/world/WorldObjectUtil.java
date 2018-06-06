package by.vit.boombony.screens.world;

import by.vit.boombony.gameobjects.Cell;
import by.vit.boombony.gameobjects.Step;
import by.vit.boombony.gameobjects.StepCursor;
import by.vit.boombony.gameworld.WorldLayerType;
import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.helpers.Coo;
import by.vit.boombony.screens.HasTileMap;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.List;

public final class WorldObjectUtil {
    /**
     * Очищаем клетку на слое
     *
     * @param mapLayer    слой
     * @param worldObject очищаемый обьект
     */
    public static void clearCell(final TiledMapTileLayer mapLayer, final Cell worldObject) {
        mapLayer.setCell(worldObject.getCoo().x, worldObject.getCoo().y, null);
        worldObject.setCoo(null);
    }

    /**
     * Очищаем клетку на слое
     *
     * @param coo cursor for clear
     */
    public static void clearCursor(Coo coo) {
        TiledMapTileLayer.Cell cell = WorldTxLibrary.CURSOR_LAYER.getCell(coo.x, coo.y);
        if (cell != null && cell instanceof StepCursor) {
            StepCursor cursor = (StepCursor) cell;
            WorldTxLibrary.CURSOR_LAYER.setCell(coo.x, coo.y, null);
            cursor.setCoo(null);
        }
    }

    /**
     * Очищаем клетку на слое
     *
     * @param coo step for clear
     */
    public static void clearCursorLayer(Coo coo) {
        TiledMapTileLayer.Cell cell = WorldTxLibrary.CURSOR_LAYER.getCell(coo.x, coo.y);
        if (cell != null) {
            if (cell instanceof Cell) {
                Cell myCell = (Cell) cell;
                myCell.setCoo(null);
            }
            WorldTxLibrary.CURSOR_LAYER.setCell(coo.x, coo.y, null);
        }
    }

    /**
     * Очищаем клетки на слое
     *
     * @param mapLayer слой
     * @param coos     список координат
     */
    public static void clearCells(final TiledMapTileLayer mapLayer, final List<Coo> coos) {
        if (coos == null) {
            return;
        }
        for (Coo coo : coos) {
            TiledMapTileLayer.Cell tileCell = mapLayer.getCell(coo.x, coo.y);
            if (WorldObjectType.STEP == getCellType(tileCell)) {
                Cell cell = (Cell) tileCell;
                mapLayer.setCell(coo.x, coo.y, null);
                cell.setCoo(null);
            }
        }
    }

    public static WorldObjectType getCellType(TiledMapTileLayer.Cell cell) {
        if (cell != null && cell.getTile() != null) {
            Object object = cell.getTile().getProperties().get(WorldObjectType.TYPE);
            if (object != null) {
                return (WorldObjectType) object;
            }
        }

        return WorldObjectType.NONE;
    }

    /**
     * Прорисовываем степы
     *
     * @param currentSteps список координат, где мы должны прорисовать степы
     */
    public static void drawSteps(List<Coo> currentSteps, int maxStepCount, WorldTxLibrary txLibrary) {
        // currentSteps первый и последний элемент не должны прорисосываться в виде степов так как это герой и курсор.
        TiledMapTileLayer objectLayer = txLibrary.getLayer(WorldLayerType.OBJECTS);
        // currentSteps - степы в списке расположены с target к hero
        for (int i = currentSteps.size() - 1; i >= 0; i--) {
            if (i == 0 || i == currentSteps.size() - 1) {
                continue;
            }
            Coo currentCoo = currentSteps.get(i);
            // если шаги выходят за максимальное колличество, которое имеет герой, то помечаем как out
            if (currentSteps.size() - (i + 1) <= maxStepCount) {
                objectLayer.setCell(currentCoo.x, currentCoo.y, new Step(txLibrary.txRegion("maps/step.png"), currentCoo).getCell());
            } else {
                objectLayer.setCell(currentCoo.x, currentCoo.y, new Step(txLibrary.txRegion("maps/step-out.png"), currentCoo).getCell());
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
        TiledMapTileLayer objectLayer = txLibrary.getLayer(WorldLayerType.CURSOR);
        // currentSteps - степы в списке расположены с target к hero
        for (int i = currentSteps.size() - 1; i >= 0; i--) {
            if (i == 0 || i == currentSteps.size() - 1) {
                continue;
            }
            Coo currentCoo = currentSteps.get(i);
            // если шаги выходят за максимальное колличество, которое имеет герой, то помечаем как out
            objectLayer.setCell(currentCoo.x, currentCoo.y, new Step(txLibrary.txRegion("maps/step.png"), currentCoo).getCell());
        }
    }

    // check Can we move cursor to coo position
    public static boolean canMove(Coo targetCoo, HasTileMap layers) {
        TiledMapTileLayer groundLayer = layers.getLayer(WorldLayerType.GROUND);
        TiledMapTileLayer objectLayer = layers.getLayer(WorldLayerType.OBJECTS);
        TiledMapTileLayer.Cell object = objectLayer.getCell(targetCoo.x, targetCoo.y);

        // we can not move behind the borders of map
        if (groundLayer.getWidth() < targetCoo.y + 1 || groundLayer.getHeight() < targetCoo.x + 1) {
            return false;
        }

        // we can not move on walls
        if (objectLayer.isVisible() && !WorldObjectType.isTransit(object) && !WorldObjectType.canCommunicate(object)) {
            return false;
        }
        return true;
    }
}
