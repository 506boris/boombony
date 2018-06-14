package by.vit.boombony.common.map;

import by.vit.boombony.gameobjects.Cell;
import by.vit.boombony.gameobjects.StepCursor;
import by.vit.boombony.gameobjects.WorldObject;
import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.helpers.Coo;
import by.vit.boombony.helpers.CoordinateUtil;
import by.vit.boombony.screens.world.CollisionActionType;
import by.vit.boombony.screens.world.WorldObjectUtil;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class MoveMapHelper {

    public static void moveCursor(WorldObject target, Coo newCoo) {
        move(target, newCoo, WorldTiledMap.cursorLayer);
    }

    public static void moveObject(WorldObject target, Coo newCoo) {
        move(target, newCoo, WorldTiledMap.objectLayer);
    }

    public static void moveCursor(WorldObject target, int x, int y) {
        move(target, new Coo(x, y), WorldTiledMap.cursorLayer);
    }

    public static void moveObject(WorldObject target, int x, int y) {
        move(target, new Coo(x, y), WorldTiledMap.objectLayer);
    }

    public static void move(WorldObject target, Coo newCoo, TiledMapTileLayer mapLayer) {
        Cell targetCell = target.getCell();
        if (targetCell.getCoo() != null) {
            TiledMapTileLayer.Cell cell = mapLayer.getCell(targetCell.getCoo().x, targetCell.getCoo().y);
            if (cell != null) {
                mapLayer.setCell(targetCell.getCoo().x, targetCell.getCoo().y, null);
            }
        }

        targetCell.setCoo(newCoo);
        int[] coordinates = CoordinateUtil.getCoordinates(newCoo);
        target.setPosition(coordinates[0], coordinates[1]);
        mapLayer.setCell(newCoo.x, newCoo.y, targetCell);
    }


    // check Can we move cursor to coo position
    public static boolean canMove(Coo targetCoo) {
        TiledMapTileLayer.Cell object = WorldTiledMap.objectLayer.getCell(targetCoo.x, targetCoo.y);

        // we can not move behind the borders of map
        if (WorldTiledMap.groundLayer.getWidth() < targetCoo.y + 1 || WorldTiledMap.groundLayer.getHeight() < targetCoo.x + 1) {
            return false;
        }

        // we can not move on walls
        if (WorldTiledMap.objectLayer.isVisible() && !WorldObjectType.isTransit(object) && !WorldObjectType.canCommunicate(object)) {
            return false;
        }
        return true;
    }

    /**
     * Move actor to coordinate coo
     *
     * @param coo target coo
     */
    public static void moveActor(WorldObject worldObject, Coo coo) {
        // if cell contains any object we can not remove it silently, current decision - stop moving
        TiledMapTileLayer.Cell cell = WorldTiledMap.cursorLayer.getCell(coo.x, coo.y);

        // we should move only by built steps
        if (WorldObjectType.isStep(cell)) {
            MoveMapHelper.move(worldObject, coo, WorldTiledMap.objectLayer);
            WorldTiledMap.clearOnCursorLayer(coo);
        }

        // if the last cell is cursor and this cell is transit on OBJECT layer we can do last step
        if (WorldObjectType.isCursor(cell)) {
            WorldTiledMap.clearOnCursorLayer(coo);

            TiledMapTileLayer.Cell objectCell = WorldTiledMap.objectLayer.getCell(coo.x, coo.y);

            if (WorldObjectType.isTransit(objectCell)) {
                MoveMapHelper.move(worldObject, coo, WorldTiledMap.objectLayer);
            }

            // should call action for object on cursor place if object can do action
            WorldObject targetWorldObject = WorldObjectUtil.tryCast(objectCell);
            if (targetWorldObject != null) {
                targetWorldObject.doAction(worldObject);
            }
        }
    }

    /**
     * Move cursor from to coordinates
     *
     * @param stepCursor stepCursor
     * @param targetCoo  to
     */
    public static void moveCursor(StepCursor stepCursor, Coo targetCoo) {

        if (stepCursor.getCoo() != null) {
            TiledMapTileLayer.Cell cell = WorldTiledMap.cursorLayer.getCell(stepCursor.getCoo().x, stepCursor.getCoo().y);
            if (cell != null) {
                WorldTiledMap.cursorLayer.setCell(stepCursor.getCoo().x, stepCursor.getCoo().y, null);
            }
        }

        stepCursor.setCoo(targetCoo);
        WorldTiledMap.cursorLayer.setCell(targetCoo.x, targetCoo.y, stepCursor);

        WorldObject worldObject = WorldObjectUtil.tryCast(WorldTiledMap.objectLayer.getCell(targetCoo.x, targetCoo.y));
        if (worldObject != null) {
            CollisionActionType type = worldObject.getCollisionActionType();
            if (type == CollisionActionType.BATTLE) {
                stepCursor.showBattleCursor();
            }
        }
    }

    public static void move(Cell targetCell, Coo newCoo, TiledMapTileLayer mapLayer) {
        if (targetCell.getCoo() != null) {
            TiledMapTileLayer.Cell cell = mapLayer.getCell(targetCell.getCoo().x, targetCell.getCoo().y);
            if (cell != null) {
                mapLayer.setCell(targetCell.getCoo().x, targetCell.getCoo().y, null);
            }
        }

        targetCell.setCoo(newCoo);
        mapLayer.setCell(newCoo.x, newCoo.y, targetCell);
    }

}
