package by.vit.boombony.screens.world;

import by.vit.boombony.gameworld.AbstractTxLibrary;
import by.vit.boombony.gameworld.Scenario;
import by.vit.boombony.gameworld.WorldLayerType;
import by.vit.boombony.helpers.Const;
import by.vit.boombony.screens.HasTileMap;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class WorldTxLibrary extends AbstractTxLibrary implements HasTileMap {
    public Scenario scenario;
    public TiledMap tiledMap;
    public TextureRegion cursorTexture;
    public TextureRegion heroTexture;
    public TextureRegion enemy1Texture;
    public TextureRegion enemy2Texture;
    public TextureRegion stepTexture;
    public TextureRegion stepOutTexture;
    public TextureRegion bombTexture;
    public TextureRegion nextStepTexture;
    public TiledMapTileLayer OBJECTS_LAYER;
    public TiledMapTileLayer GROUND_LAYER;
    public TiledMapTileLayer CURSOR_LAYER;

    public WorldTxLibrary(Scenario scenario) {
        this.scenario = scenario;
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
        this.tiledMap = new TmxMapLoader().load(scenario.getTmxMapPath());
        OBJECTS_LAYER = getLayer(WorldLayerType.OBJECTS);
        GROUND_LAYER = getLayer(WorldLayerType.GROUND);
        CURSOR_LAYER = getLayer(WorldLayerType.CURSOR);

        // todo оптимизировать - - влияент на производительность.!!
        this.cursorTexture = new TextureRegion(createTexture("maps/activecell.png"), 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
        this.heroTexture = new TextureRegion(createTexture("maps/hero.png"), 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
        this.enemy1Texture = new TextureRegion(createTexture("maps/enemy1.png"), 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
        this.enemy2Texture = new TextureRegion(createTexture("maps/enemy2.png"), 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
        this.stepTexture = new TextureRegion(createTexture("maps/step.png"), 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
        this.stepOutTexture = new TextureRegion(createTexture("maps/step-out.png"), 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
        this.bombTexture = new TextureRegion(createTexture("maps/bomb.png"), 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
        this.nextStepTexture = new TextureRegion(createTexture("button/next_step.png"), 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
    }
}
