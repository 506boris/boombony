package by.vit.boombony.screens.menu;

import by.vit.boombony.helpers.ScenarioHelper;
import by.vit.boombony.screens.AbstractScreen;
import by.vit.boombony.screens.ScreenManager;
import by.vit.boombony.screens.world.WorldScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Main menu
 */
public class MenuScreen extends AbstractScreen<MenuTxLibrary> implements MenuScreenView {
    private SpriteBatch batch;
    private MenuStage menuStage;
    private Sprite bgSprite;
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

        bgSprite = new Sprite(txLibrary.bg);
        bgSprite.setPosition(0, 0);


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
        batch.begin();
        bgSprite.draw(batch);
        batch.end();

        menuStage.update(delta);
        menuStage.draw();
    }

    @Override
    public void dispose() {
        menuStage.dispose();
    }
}
