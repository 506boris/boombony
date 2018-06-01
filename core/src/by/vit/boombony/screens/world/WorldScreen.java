package by.vit.boombony.screens.world;

import by.vit.boombony.gameobjects.*;
import by.vit.boombony.gameworld.WorldLayerType;
import by.vit.boombony.gameworld.Scenario;
import by.vit.boombony.helpers.Coo;
import by.vit.boombony.helpers.MoveHelper;
import by.vit.boombony.screens.AbstractScreen;
import by.vit.boombony.screens.ScreenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.GL20;

public class WorldScreen extends AbstractScreen<WorldTxLibrary> {
    private ScreenManager screenManager;
    private WorldRenderer worldRenderer;
    private HUDStage hudStage;
    private InputMultiplexer inputMultiplexer;
    Hero hero;

    public WorldScreen(ScreenManager screenManager, Scenario scenario) {
        super(new WorldTxLibrary(scenario));
        this.screenManager = screenManager;
        this.hudStage = new HUDStage();
        this.worldRenderer = new WorldRenderer(this, screenManager, hudStage);
        this.inputMultiplexer = new InputMultiplexer();
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
        initPersons();
        initInputProcessor();
    }

    private void initInputProcessor() {
        StepCursor cursor = new StepCursor(txLibrary.cursorTexture);
        InputController inputController = new InputController(worldRenderer.getCamera(), cursor, hero, txLibrary);
        // порядок важен, кто первый добавлен тот и выше преоритетом при клике
        this.inputMultiplexer.addProcessor(hudStage);
        this.inputMultiplexer.addProcessor(inputController);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    private void initPersons() {
        this.hero = new Hero(txLibrary.heroTexture);
        MoveHelper.move(hero, Coo.zero(), txLibrary.getLayer(WorldLayerType.OBJECTS));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f / 255f, 0f / 255f, 0f / 255f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        worldRenderer.render(delta);
    }

    @Override
    public void resize(int width, int height) {
//        extendViewport.update(width,height,false);
    }

    @Override
    public void dispose() {
        super.dispose();
        txLibrary.dispose();
    }
}