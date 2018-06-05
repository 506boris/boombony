package by.vit.boombony.screens.world;

import by.vit.boombony.gameobjects.*;
import by.vit.boombony.gameworld.Scenario;
import by.vit.boombony.screens.AbstractScreen;
import by.vit.boombony.screens.ScreenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

public class WorldScreen extends AbstractScreen<WorldTxLibrary> {
    private ScreenManager screenManager;
    private WorldRenderer worldRenderer;
    private HUDStage hudStage;
    private InputMultiplexer inputMultiplexer;
    private WorldStage worldStage;

    public WorldScreen(ScreenManager screenManager, Scenario scenario) {
        super(new WorldTxLibrary(scenario));
        this.screenManager = screenManager;
        this.hudStage = new HUDStage();
        this.worldRenderer = new WorldRenderer(this, screenManager, hudStage);
        this.inputMultiplexer = new InputMultiplexer();
        this.worldStage = new WorldStage(worldRenderer.getCamera(), txLibrary);
    }

    @Override
    public void loadTx() {
        super.loadTx();
        hudStage.loadTx();
    }

    @Override
    public void show() {
        this.hudStage.init();
        this.worldRenderer.init();
        this.worldStage.init();
        initInputProcessor();
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
        worldRenderer.render(delta);
        worldStage.render(delta);
        worldStage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        txLibrary.dispose();
    }

    @Deprecated
    public Hero getHero() {
        return worldStage.getHero();
    }
}