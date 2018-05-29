package by.vit.boombony.screens;

import by.vit.boombony.gameworld.WorldLayerType;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public interface HasTileMap {
    TiledMapTileLayer getLayer(WorldLayerType worldLayerType);
    TiledMap getTiledMap();
}
