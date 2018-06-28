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

//        LevelInfo levelInfo = levelScenario.getLevelInfo();
//        NpcArray npcArray = levelInfo.getNpcArray();
//        List<NpcModel> npcModels = npcArray.getNpc();
//        List<MonsterModel> monsterModels = npcArray.getMonsters();
//
//        for (NpcModel model : npcModels) {
//            createTextureRegion("maps/", model.getMapTextureName(), model.getSize().x, model.getSize().y);
//        }
//        for (MonsterModel model : monsterModels) {
//            createTextureRegion("maps/", model.getMapTextureName(), model.getSize().x, model.getSize().y);
//        }

        // todo оптимизировать - - влияент на производительность.!!
    }
}
