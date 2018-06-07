package by.vit.boombony.screens.world;

import by.vit.boombony.scenario.LevelScenario;
import by.vit.boombony.screens.AbstractScreen;
import by.vit.boombony.screens.ScreenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;

public class WorldScreen extends AbstractScreen<WorldTxLibrary> {
    private ScreenManager screenManager;
    private OrthographicCamera camera;
    private HUDStage hudStage;
    private InputMultiplexer inputMultiplexer;
    private WorldStage worldStage;

    public WorldScreen(ScreenManager screenManager, LevelScenario levelScenario) {
        super(new WorldTxLibrary(levelScenario));
        this.screenManager = screenManager;
        this.hudStage = new HUDStage();
        this.inputMultiplexer = new InputMultiplexer();
        this.worldStage = new WorldStage(this, txLibrary);
    }

    @Override
    public void loadTx() {
        super.loadTx();
        hudStage.loadTx();
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
    }

    @Override
    public void dispose() {
        super.dispose();
        txLibrary.dispose();
    }

    public ScreenManager getScreenManager() {
        return screenManager;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}