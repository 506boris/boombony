package by.vit.boombony.helpers;

import by.vit.boombony.gameobjects.Cell;
import by.vit.boombony.gameobjects.HasWorldObjectType;
import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.screens.world.WorldTxLibrary;

import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector3;

public class MoveHelper {
    /**
     * Move the cursor to another position. Before this we remove cursor from old position.
     *
     * @param cursorMapLayer layer with cursor
     * @param cursor         cursor
     * @param newCoo         new coordinate for cursor
     */
//    public static void moveCursor(final Cell cursor, final Coo newCoo, final TiledMapTileLayer cursorMapLayer) {
//        if (cursor.getCoo() != null) {
//            TiledMapTileLayer.Cell cell = cursorMapLayer.getCell(cursor.getCoo().x, cursor.getCoo().y);
//            if (cell != null) {
//                cursorMapLayer.setCell(cursor.getCoo().x, cursor.getCoo().y, null);
//            }
//        }
//
//        cursor.setCoo(newCoo);
//
////        Gdx.app.log("new coordinate ", "(" + String.valueOf(newCoo.x) + " : " + String.valueOf(newCoo.y) + ")");
//        cursorMapLayer.setCell(newCoo.x, newCoo.y, cursor);
//    }
    public static void moveCursor(Cell target, Coo newCoo) {
        move(target, newCoo, WorldTxLibrary.CURSOR_LAYER);
    }

    public static void moveObject(Cell target, Coo newCoo) {
        move(target, newCoo, WorldTxLibrary.OBJECTS_LAYER);
    }

    public static void moveCursor(Cell target, int x, int y) {
        move(target, new Coo(x, y), WorldTxLibrary.CURSOR_LAYER);
    }

    public static void moveObject(Cell target, int x, int y) {
        move(target, new Coo(x, y), WorldTxLibrary.OBJECTS_LAYER);
    }

    public static void move(Cell target, Coo newCoo, TiledMapTileLayer mapLayer) {
        if (target.getCoo() != null) {
            TiledMapTileLayer.Cell cell = mapLayer.getCell(target.getCoo().x, target.getCoo().y);
            if (cell != null) {
                mapLayer.setCell(target.getCoo().x, target.getCoo().y, null);
            }
        }

        target.setCoo(newCoo);

//        Gdx.app.log("DynamicWorldObject ", "(" + String.valueOf(newCoo.x) + " : " + String.valueOf(newCoo.y) + ")");
        mapLayer.setCell(newCoo.x, newCoo.y, target);
    }
//
//    public static void moveSmooth(Cell target, Coo newCoo, TiledMapTileLayer mapLayer) {
//        if (target.getCoo() != null) {
//            TiledMapTileLayer.Cell cell = mapLayer.getCell(target.getCoo().x, target.getCoo().y);
//            if (cell != null) {
//                mapLayer.setCell(target.getCoo().x, target.getCoo().y, null);
//            }
//        }
//
//        target.setCoo(newCoo);
//
////        Gdx.app.log("DynamicWorldObject ", "(" + String.valueOf(newCoo.x) + " : " + String.valueOf(newCoo.y) + ")");
//        mapLayer.setCell(newCoo.x, newCoo.y, target);
//    }
}
