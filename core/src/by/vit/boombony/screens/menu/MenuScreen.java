package by.vit.boombony.screens.menu;

import by.vit.boombony.helpers.ScenarioHelper;
import by.vit.boombony.screens.AbstractScreen;
import by.vit.boombony.screens.ScreenManager;
import by.vit.boombony.screens.world.WorldScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Меню игры.
 */
public class MenuScreen extends AbstractScreen implements MenuScreenView {
    private SpriteBatch batch;
    private MenuStage menuStage;
    private Sprite bgSprite;
    protected ScreenManager screenManager;

    public MenuScreen(ScreenManager screenManager) {
        super(new MenuTxLibrary());
        this.screenManager = screenManager;
    }

    @Override
    public void show() {
        MenuTxLibrary txLibrary = getTxLibrary();

        batch = new SpriteBatch();
        menuStage = new MenuStage(txLibrary);
        menuStage.setScreenView(this);

        bgSprite = new Sprite(txLibrary.bg);
        bgSprite.setPosition(0, 0);


        Gdx.input.setInputProcessor(menuStage);
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
