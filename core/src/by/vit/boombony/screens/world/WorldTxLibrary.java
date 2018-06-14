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
    public TextureRegion dialogBackground;
    public TextureRegion dialogOkEnabled;
    public TextureRegion dialogOkPressed;

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

        createTextureRegion("maps/activecell.png");
        createTextureRegion("maps/step.png");
        createTextureRegion("maps/step-out.png");
        createTextureRegion("button/next_step.png");
        createTextureRegion("maps/old_duke.png", 0, 0, 106, 147);
        createTextureRegion("maps/face_zloboglaz.png", 0, 0, 106, 147);
        createTextureRegion("maps/face_Severus.png", 0, 0, 106, 147);
        createTextureRegion("maps/face_Jim.png", 0, 0, 106, 147);
        createTextureRegion("maps/ButtonRage_normal.png", 0, 0, 77, 74);
        createTextureRegion("maps/Face_witch_Helga.png", 0, 0, 106, 147);
        dialogBackground = new TextureRegion(createTexture("dialog_bg_top.png"), 954, 620);
        dialogOkEnabled = new TextureRegion(createTexture("button/button_ok_enabled_2.png"), 130, 38);
        dialogOkPressed = new TextureRegion(createTexture("button/button_ok_pressed_2.png"), 130, 38);

        // todo оптимизировать - - влияент на производительность.!!
    }
}
