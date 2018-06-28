package by.vit.boombony.texture;

import by.vit.boombony.common.map.WorldTiledMap;
import by.vit.boombony.scenario.models.LevelInfo;
import by.vit.boombony.scenario.models.LevelScenario;
import by.vit.boombony.scenario.models.MonsterModel;
import by.vit.boombony.scenario.models.NpcArray;
import by.vit.boombony.scenario.models.NpcModel;
import by.vit.boombony.screens.HasTileMap;

import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import java.util.List;

public class WorldTxLibrary extends BaseTxLibrary implements HasTileMap {
    public LevelScenario levelScenario;
    public WorldTiledMap tiledMap;

    public WorldTxLibrary(LevelScenario levelScenario) {
        this.levelScenario = levelScenario;
    }

    @Override
    public WorldTiledMap getTiledMap() {
        return tiledMap;
    }

    @Override
    public void load() {
        this.tiledMap = new WorldTiledMap(new TmxMapLoader().load(levelScenario.getTmxMapPath()));

        createTextureRegion("dialog_bg_top.png", 954, 620);
        createTextureRegion("button/", "button_ok_enabled_2.png", 130, 38);
        createTextureRegion("button/", "button_ok_pressed_2.png", 130, 38);

        createTextureRegion("maps/", "activecell.png");
        createTextureRegion("maps/", "activecell_attack.png");
        createTextureRegion("maps/", "step.png");
        createTextureRegion("maps/", "step-out.png");
        createTextureRegion("button/", "next_step.png");

        LevelInfo levelInfo = levelScenario.getLevelInfo();
        NpcArray npcArray = levelInfo.getNpcArray();
        List<NpcModel> npcModels = npcArray.getNpc();
        List<MonsterModel> monsterModels = npcArray.getMonsters();

        for (NpcModel model : npcModels) {
            createTextureRegion("maps/", model.getMapTextureName(), model.getSize().x, model.getSize().y);
        }
        for (MonsterModel model : monsterModels) {
            createTextureRegion("maps/", model.getMapTextureName(), model.getSize().x, model.getSize().y);
        }

        // todo оптимизировать - - влияент на производительность.!!
    }
}
