package by.vit.boombony.screens.world;

import by.vit.boombony.gameworld.AbstractTxLibrary;
import by.vit.boombony.gameworld.Scenario;
import by.vit.boombony.gameworld.TxLibrary;
import by.vit.boombony.gameworld.WorldLayerType;
import by.vit.boombony.helpers.Const;
import by.vit.boombony.screens.HasTileMap;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

import java.util.ArrayList;
import java.util.List;

public class WorldTxLibrary extends AbstractTxLibrary implements HasTileMap {
    public TiledMap tiledMap;
    public TextureRegion cursorTexture;
    public TextureRegion heroTexture;
    public TextureRegion enemy1Texture;
    public TextureRegion enemy2Texture;
    public TextureRegion stepTexture;
    public TextureRegion stepOutTexture;
    public TextureRegion bombTexture;
    public TextureRegion nextStepTexture;

    @Override
    public TiledMapTileLayer getLayer(WorldLayerType worldLayerType) {
        return ((TiledMapTileLayer) tiledMap.getLayers().get(worldLayerType.getName()));
    }

    @Override
    public TiledMap getTiledMap() {
        return tiledMap;
    }

    @Override
    public void load(Scenario scenario) {
        this.tiledMap = new TmxMapLoader().load(scenario.getTmxMapPath());

        // todo оптимизировать - - влияент на производительность.!!
        this.cursorTexture = new TextureRegion(texture("maps/activecell.png"), 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
        this.heroTexture = new TextureRegion(texture("maps/hero.png"), 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
        this.enemy1Texture = new TextureRegion(texture("maps/enemy1.png"), 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
        this.enemy2Texture = new TextureRegion(texture("maps/enemy2.png"), 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
        this.stepTexture = new TextureRegion(texture("maps/step.png"), 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
        this.stepOutTexture = new TextureRegion(texture("maps/step-out.png"), 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
        this.bombTexture = new TextureRegion(texture("maps/bomb.png"), 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
        this.nextStepTexture = new TextureRegion(texture("button/next_step.png"), 0, 0, Const.TILE_SIZE, Const.TILE_SIZE);
    }
}
