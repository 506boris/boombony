package by.vit.boombony.common.map;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;

import by.vit.boombony.gameobjects.Cell;
import by.vit.boombony.helpers.Coo;

public class WorldTiledMap extends TiledMap {

    public WorldTiledMap() {
        super();
    }

    public WorldTiledMap(TiledMap tiledMap) {
        for (TiledMapTileSet tileSet : tiledMap.getTileSets()) {
            getTileSets().addTileSet(tileSet);
        }

        for (MapLayer layer : tiledMap.getLayers()) {
            getLayers().add(layer);
        }

        this.getProperties().putAll(tiledMap.getProperties());
    }

    public void moveCursor(Coo cursorCoo, Coo targetCoo) {
        TiledMapTileLayer cursorLayer = cursorLayer();
        Cell targetCell = (Cell) cursorLayer.getCell(cursorCoo.x, cursorCoo.y);

        if (targetCell.getCoo() != null) {
            TiledMapTileLayer.Cell cell = cursorLayer.getCell(targetCell.getCoo().x, targetCell.getCoo().y);
            if (cell != null) {
                cursorLayer.setCell(targetCell.getCoo().x, targetCell.getCoo().y, null);
            }
        }

        targetCell.setCoo(targetCoo);
        cursorLayer.setCell(targetCoo.x, targetCoo.y, targetCell);
    }

    public TiledMapTileLayer objectLayer() {
        return (TiledMapTileLayer) getLayers().get(WorldLayerType.OBJECTS.getName());
    }

    public TiledMapTileLayer groundLayer() {
        return (TiledMapTileLayer) getLayers().get(WorldLayerType.GROUND.getName());
    }

    public TiledMapTileLayer cursorLayer() {
        return (TiledMapTileLayer) getLayers().get(WorldLayerType.CURSOR.getName());
    }
}
