package by.vit.boombony.screens.world;

import by.vit.boombony.gameobjects.*;
import by.vit.boombony.gameworld.Scenario;
import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.helpers.MoveHelper;
import by.vit.boombony.screens.AbstractScreen;
import by.vit.boombony.screens.ScreenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;


public class WorldScreen extends AbstractScreen<WorldTxLibrary> {
    private ScreenManager screenManager;
    private WorldRenderer worldRenderer;
    private HUDStage hudStage;
    private InputMultiplexer inputMultiplexer;
    protected Hero hero;

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
        StepCursor cursor = new StepCursor(txLibrary.txRegion("maps/activecell.png"));
        WorldInputController worldInputController = new WorldInputController(worldRenderer.getCamera(), cursor, hero, txLibrary);
        // порядок важен, кто первый добавлен тот и выше преоритетом при клике
        this.inputMultiplexer.addProcessor(hudStage);
        this.inputMultiplexer.addProcessor(worldInputController);
        Gdx.input.setInputProcessor(inputMultiplexer);
    }

    private void initPersons() {
        this.hero = new Hero(txLibrary.txRegion("maps/hero.png"));
        MoveHelper.moveObject(hero, 0, 0);

        Person oldDukePerson = new Person(txLibrary.txRegion("maps/old_duke.png"), WorldObjectType.NEUTRAL);
        MoveHelper.moveObject(oldDukePerson, 3, 0);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        worldRenderer.render(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
        txLibrary.dispose();
    }
}