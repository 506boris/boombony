package by.vit.boombony.screens;

import by.vit.boombony.common.map.WorldTiledMap;
import by.vit.boombony.common.map.WorldLayerType;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public interface HasTileMap {
    WorldTiledMap getTiledMap();
}
