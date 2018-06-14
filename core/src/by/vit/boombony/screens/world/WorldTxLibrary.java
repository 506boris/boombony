package by.vit.boombony.screens.world;

import by.vit.boombony.common.map.WorldTiledMap;
import by.vit.boombony.gameworld.BaseTxLibrary;
import by.vit.boombony.scenario.LevelScenario;
import by.vit.boombony.screens.HasTileMap;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

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

        createTextureRegion("maps/", "activecell.png");
        createTextureRegion("maps/", "activecell_attack.png");
        createTextureRegion("maps/", "step.png");
        createTextureRegion("maps/", "step-out.png");
        createTextureRegion("button/", "next_step.png");
        createTextureRegion("maps/", "face_zloboglaz.png", 106, 147);
        createTextureRegion("maps/", "face_Severus.png", 106, 147);
        createTextureRegion("maps/", "face_Jim.png", 106, 147);
        createTextureRegion("maps/", "ButtonRage_normal.png", 77, 74);
        createTextureRegion("maps/", "Face_witch_Helga.png", 106, 147);
        createTextureRegion("maps/", "face_viking_house_small_3_autumn.png", 106, 147);
        createTextureRegion("maps/", "face_viking_house_small_3_winter.png", 106, 147);
        createTextureRegion("maps/", "face_viking_lighthouse.png", 106, 147);
        createTextureRegion("maps/", "face_viking_makinghides_machine.png", 106, 147);
        createTextureRegion("maps/", "face_viking_mill.png", 106, 147);
        createTextureRegion("maps/", "face_Volkan.png", 106, 147);
        createTextureRegion("maps/", "face_werewolf.png", 106, 147);
        createTextureRegion("maps/", "face_white_beer.png", 106, 147);
        createTextureRegion("maps/", "face_witch_Etteila.png", 106, 147);
        createTextureRegion("maps/", "face_witch_Hestra.png", 106, 147);
        createTextureRegion("maps/", "face_Witch_Kimora.png", 106, 147);
        createTextureRegion("maps/", "Face_witch_magnet.png", 106, 147);
        createTextureRegion("maps/", "face_witch_martaold.png", 106, 147);
        createTextureRegion("maps/", "face_witch_Wilma.png", 106, 147);
        createTextureRegion("maps/", "face_Yanik_up.png", 106, 147);
        createTextureRegion("maps/", "face_Yodur.png", 106, 147);
        createTextureRegion("maps/", "face_yotun.png", 106, 147);
        createTextureRegion("maps/", "face_zelgadis.png", 106, 147);
        createTextureRegion("maps/", "face_zloboglaz.png", 106, 147);

        // todo оптимизировать - - влияент на производительность.!!
    }
}
