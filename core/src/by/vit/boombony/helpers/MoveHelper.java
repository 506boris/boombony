package by.vit.boombony.helpers;

import by.vit.boombony.gameobjects.Cell;
import by.vit.boombony.gameobjects.WorldObject;
import by.vit.boombony.screens.world.WorldTxLibrary;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class MoveHelper {

    public static void moveCursor(WorldObject target, Coo newCoo) {
        move(target, newCoo, WorldTxLibrary.CURSOR_LAYER);
    }

    public static void moveObject(WorldObject target, Coo newCoo) {
        move(target, newCoo, WorldTxLibrary.OBJECTS_LAYER);
    }

    public static void moveCursor(WorldObject target, int x, int y) {
        move(target, new Coo(x, y), WorldTxLibrary.CURSOR_LAYER);
    }

    public static void moveObject(WorldObject target, int x, int y) {
        move(target, new Coo(x, y), WorldTxLibrary.OBJECTS_LAYER);
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
