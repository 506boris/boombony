package by.vit.boombony.texture;

import by.vit.boombony.common.map.WorldTiledMap;
import by.vit.boombony.scenario.models.LevelScenario;
import by.vit.boombony.screens.HasTileMap;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class WorldTileMapTxLibrary implements TxLibrary, HasTileMap {
    public LevelScenario levelScenario;
    public WorldTiledMap tiledMap;

    public WorldTileMapTxLibrary(LevelScenario levelScenario) {
        this.levelScenario = levelScenario;
    }

    @Override
    public WorldTiledMap getTiledMap() {
        return tiledMap;
    }

    @Override
    public void dispose() {
        tiledMap.dispose();
    }

    @Override
    public void load() {
        this.tiledMap = new WorldTiledMap(new TmxMapLoader().load(levelScenario.getTmxMapPath()));
    }
}
