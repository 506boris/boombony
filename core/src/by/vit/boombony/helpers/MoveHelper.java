package by.vit.boombony.helpers;

import by.vit.boombony.gameobjects.Cell;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

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

    public static void move(Cell target, Coo newCoo, TiledMapTileLayer mapLayer) {
        if (target.getCoo() != null) {
            TiledMapTileLayer.Cell cell = mapLayer.getCell(target.getCoo().x, target.getCoo().y);
            if (cell != null) {
                mapLayer.setCell(target.getCoo().x, target.getCoo().y, null);
            }
        }

        target.setCoo(newCoo);

//        Gdx.app.log("WorldObject ", "(" + String.valueOf(newCoo.x) + " : " + String.valueOf(newCoo.y) + ")");
        mapLayer.setCell(newCoo.x, newCoo.y, target);
    }
}
