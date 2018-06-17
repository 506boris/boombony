package by.vit.boombony.screens.menu;

import by.vit.boombony.common.sprites.BaseBackground;
import by.vit.boombony.helpers.ScenarioHelper;
import by.vit.boombony.screens.AbstractScreen;
import by.vit.boombony.screens.ScreenManager;
import by.vit.boombony.screens.world.WorldScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Main menu
 */
public class MenuScreen extends AbstractScreen<MenuTxLibrary> implements MenuScreenView {
    private SpriteBatch batch;
    private MenuStage menuStage;
    private BaseBackground bgSprite;
    private ScreenManager screenManager;

    public MenuScreen(ScreenManager screenManager) {
        super(new MenuTxLibrary());
        this.screenManager = screenManager;
    }

    @Override
    public void show() {

        batch = screenManager.getGame().getBatch();
        menuStage = new MenuStage(txLibrary);
        menuStage.init();
        menuStage.setScreenView(this);

        bgSprite = new BaseBackground(txLibrary.bg);

        Gdx.input.setInputProcessor(menuStage);
    }

    @Override
    public void loadTx() {
        super.loadTx();
        // todo menu.loadTx()
    }

    @Override
    public void startGame() {
        screenManager.show(new WorldScreen(screenManager, ScenarioHelper.getScenario0()));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        bgSprite.draw(batch);
        batch.end();

        menuStage.render(delta);
        menuStage.draw();
    }

    @Override
    public void dispose() {
        menuStage.dispose();
    }
}
