package by.vit.boombony.helpers;

import by.vit.boombony.gameobjects.BCell;
import by.vit.boombony.maps.Cell;
import by.vit.boombony.screens.menu.MenuScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.utils.Timer;

import java.util.List;

public class MoveHelper {
    /**
     * Move the cursor to another position. Before this we remove cursor from old position.
     *
     * @param cursorMapLayer layer with cursor
     * @param cursor         cursor
     * @param newCoo         new coordinate for cursor
     */
    public static void moveCursor(final BCell cursor, final Coo newCoo, final TiledMapTileLayer cursorMapLayer) {
        if (cursor.getCoo() != null) {
            TiledMapTileLayer.Cell cell = cursorMapLayer.getCell(cursor.getCoo().x, cursor.getCoo().y);
            if (cell != null) {
                cursorMapLayer.setCell(cursor.getCoo().x, cursor.getCoo().y, null);
            }
        }

        cursor.setCoo(newCoo);

//        Gdx.app.log("new coordinate ", "(" + String.valueOf(newCoo.x) + " : " + String.valueOf(newCoo.y) + ")");
        cursorMapLayer.setCell(newCoo.x, newCoo.y, cursor);
    }

    public static void move(final BCell worldObject, final Coo newCoo, final TiledMapTileLayer mapLayer) {
        if (worldObject.getCoo() != null) {
            TiledMapTileLayer.Cell cell = mapLayer.getCell(worldObject.getCoo().x, worldObject.getCoo().y);
            if (cell != null) {
                mapLayer.setCell(worldObject.getCoo().x, worldObject.getCoo().y, null);
            }
        }

        worldObject.setCoo(newCoo);

//        Gdx.app.log("WorldObject ", "(" + String.valueOf(newCoo.x) + " : " + String.valueOf(newCoo.y) + ")");
        mapLayer.setCell(newCoo.x, newCoo.y, worldObject);
    }
}
