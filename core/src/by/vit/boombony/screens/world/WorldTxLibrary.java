package by.vit.boombony.screens.world;

import by.vit.boombony.gameworld.BaseTxLibrary;
import by.vit.boombony.scenario.LevelScenario;
import by.vit.boombony.gameworld.WorldLayerType;
import by.vit.boombony.screens.HasTileMap;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class WorldTxLibrary extends BaseTxLibrary implements HasTileMap {
    public LevelScenario levelScenario;
    public TiledMap tiledMap;
    public static TiledMapTileLayer OBJECTS_LAYER;
    public static TiledMapTileLayer GROUND_LAYER;
    public static TiledMapTileLayer CURSOR_LAYER;

    public WorldTxLibrary(LevelScenario levelScenario) {
        this.levelScenario = levelScenario;
    }

    @Override
    public TiledMapTileLayer getLayer(WorldLayerType worldLayerType) {
        return ((TiledMapTileLayer) tiledMap.getLayers().get(worldLayerType.getName()));
    }

    @Override
    public TiledMap getTiledMap() {
        return tiledMap;
    }

    @Override
    public void load() {
        this.tiledMap = new TmxMapLoader().load(levelScenario.getTmxMapPath());
        OBJECTS_LAYER = getLayer(WorldLayerType.OBJECTS);
        GROUND_LAYER = getLayer(WorldLayerType.GROUND);
        CURSOR_LAYER = getLayer(WorldLayerType.CURSOR);

        createTextureRegion("maps/activecell.png");
        createTextureRegion("maps/step.png");
        createTextureRegion("maps/step-out.png");
        createTextureRegion("maps/bomb.png");
        createTextureRegion("button/next_step.png");
        createTextureRegion("maps/old_duke.png", 0, 0, 106, 147);
        createTextureRegion("maps/face_zloboglaz.png", 0, 0, 106, 147);
        createTextureRegion("maps/face_Severus.png", 0, 0, 106, 147);
        createTextureRegion("maps/face_Jim.png", 0, 0, 106, 147);
        createTextureRegion("maps/ButtonRage_normal.png", 0, 0, 77, 74);
        createTextureRegion("maps/Face_witch_Helga.png", 0, 0, 106, 147);

        // todo оптимизировать - - влияент на производительность.!!
    }
}
