package by.vit.boombony.screens.world;

import by.vit.boombony.common.map.WorldTiledMap;
import by.vit.boombony.helpers.Const;
import by.vit.boombony.scenario.models.LevelScenario;
import by.vit.boombony.screens.AbstractScreen;
import by.vit.boombony.screens.ScreenManager;
import by.vit.boombony.texture.GlobalTxLibrary;
import by.vit.boombony.texture.WorldTxLibrary;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class WorldScreen extends AbstractScreen<WorldTxLibrary> {
    private ScreenManager screenManager;
    private OrthographicCamera camera;
    private HUDStage hudStage;
    private InputMultiplexer inputMultiplexer;
    private WorldStage worldStage;
    private GlobalTxLibrary globalTxLibrary;

    public WorldScreen(ScreenManager screenManager, LevelScenario levelScenario) {
        super(new WorldTxLibrary(levelScenario));
        this.screenManager = screenManager;
        this.hudStage = new HUDStage();
        this.inputMultiplexer = new InputMultiplexer();
        this.worldStage = new WorldStage(this, txLibrary);
        this.globalTxLibrary = new GlobalTxLibrary();
    }

    @Override
    public void loadTx() {
        super.loadTx();
        hudStage.loadTx();
        globalTxLibrary.load();
    }

    @Override
    public void show() {
        this.initCamera();
        this.hudStage.init();
        this.worldStage.init();
        initInputProcessor();
    }

    private void initCamera() {
        this.camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.camera.position.set(0, 0, 0);
        this.camera.setToOrtho(false);
    }

    private void initInputProcessor() {
        // порядок важен, кто первый добавлен тот и выше преоритетом при клике
        this.inputMultiplexer.addProcessor(hudStage);
        this.inputMultiplexer.addProcessor(worldStage);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        worldStage.render(delta);
        worldStage.draw();
        hudStage.render(delta);
        hudStage.draw();

        if (Const.DEBUG) {
            debugTraceCellNumber();
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        txLibrary.dispose();
    }

    public HUDStage getHudStage() {
        return hudStage;
    }

    public ScreenManager getScreenManager() {
        return screenManager;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    private void debugTraceCellNumber() {
        BitmapFont font = new BitmapFont();
        screenManager.getGame().getBatch().begin();
        int w = WorldTiledMap.debugLayer.getWidth();
        int h = WorldTiledMap.debugLayer.getHeight();

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                font.draw(screenManager.getGame().getBatch(), i + ":" + j, Const.TILE_SIZE * i + Const.TILE_SIZE / 3, Const.TILE_SIZE * j + Const.TILE_SIZE / 2);
            }
        }
        screenManager.getGame().getBatch().end();
    }
}