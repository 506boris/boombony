package by.vit.boombony.common.map;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;

import java.util.List;

import by.vit.boombony.gameobjects.Cell;
import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.helpers.Const;
import by.vit.boombony.helpers.Coo;

public class WorldTiledMap extends TiledMap {

    public static TiledMapTileLayer groundLayer;
    public static TiledMapTileLayer objectLayer;
    public static TiledMapTileLayer cursorLayer;
    public static TiledMapTileLayer debugLayer;

    public WorldTiledMap(TiledMap tiledMap) {
        for (TiledMapTileSet tileSet : tiledMap.getTileSets()) {
            getTileSets().addTileSet(tileSet);
        }

        for (MapLayer layer : tiledMap.getLayers()) {
            getLayers().add(layer);
        }

        groundLayer = (TiledMapTileLayer) getLayers().get(WorldLayerType.GROUND.getName());
        objectLayer = (TiledMapTileLayer) getLayers().get(WorldLayerType.OBJECTS.getName());
        cursorLayer = (TiledMapTileLayer) getLayers().get(WorldLayerType.CURSOR.getName());

        if (Const.DEBUG) {
            initDebugLayer();
        }

        this.getProperties().putAll(tiledMap.getProperties());
    }

    private void initDebugLayer() {
        debugLayer = new TiledMapTileLayer(cursorLayer.getWidth(), cursorLayer.getHeight(), (int) cursorLayer.getTileWidth(), (int) cursorLayer.getTileHeight());
        getLayers().add(debugLayer);
    }

    /**
     * Очищаем клетку на слое
     *
     * @param coo step for clear
     */
    public static void clearOnCursorLayer(Coo coo) {
        TiledMapTileLayer.Cell cell = cursorLayer.getCell(coo.x, coo.y);
        if (cell != null) {
            if (cell instanceof Cell) {
                Cell myCell = (Cell) cell;
                myCell.setCoo(null);
            }
            cursorLayer.setCell(coo.x, coo.y, null);
        }
    }

    /**
     * Очищаем клетки на слое cursor
     *
     * @param coos список координат
     */
    public static void clearSteps(List<Coo> coos) {
        if (coos == null) {
            return;
        }
        for (Coo coo : coos) {
            TiledMapTileLayer.Cell tileCell = cursorLayer.getCell(coo.x, coo.y);
            if (WorldObjectType.STEP == getCellType(tileCell)) {
                Cell cell = (Cell) tileCell;
                cursorLayer.setCell(coo.x, coo.y, null);
                cell.setCoo(null);
            }
        }
    }

    /**
     * Get cell type
     *
     * @param cell cell
     * @return type
     */
    public static WorldObjectType getCellType(TiledMapTileLayer.Cell cell) {
        if (cell != null && cell.getTile() != null) {
            Object object = cell.getTile().getProperties().get(WorldObjectType.TYPE);
            if (object != null) {
                return (WorldObjectType) object;
            }
        }

        return WorldObjectType.NONE;
    }
}
