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

public class WorldScreen extends AbstractScreen {
    private ScreenManager screenManager;
    private WorldRenderer worldRenderer;
    private InputController inputController;
    private WorldTxLibrary txLibrary;
    private HUDStage hudStage;
    private InputMultiplexer inputMultiplexer = new InputMultiplexer();
    StepCursor cursor;
    Hero hero;

    public WorldScreen(ScreenManager screenManager, Scenario scenario) {
        super(new WorldTxLibrary(scenario));
        this.screenManager = screenManager;
    }

    @Override
    public void show() {
        this.txLibrary = getTxLibrary();

        HUDTxLibrary hudTxLibrary = new HUDTxLibrary();
        hudTxLibrary.load();
        this.hudStage = new HUDStage(hudTxLibrary);
        this.worldRenderer = new WorldRenderer(this, hudStage);
        this.worldRenderer.init();

        this.cursor = new StepCursor(txLibrary.cursorTexture);

        //todo
        initPersons();

        this.inputController = new InputController(worldRenderer.getCamera(), cursor, hero, txLibrary);
        // порядок важен, кто первый добавлен тот и выше преоритетом при клике
        inputMultiplexer.addProcessor(hudStage);
        inputMultiplexer.addProcessor(inputController);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    private void initPersons() {
        this.hero = new Hero(txLibrary.heroTexture);
        MoveHelper.move(hero, new Coo(0, 0), txLibrary.getLayer(WorldLayerType.OBJECTS));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f / 255f, 0f / 255f, 0f / 255f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        worldRenderer.render(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
        txLibrary.dispose();
    }
}