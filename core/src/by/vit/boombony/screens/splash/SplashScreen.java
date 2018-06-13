package by.vit.boombony.screens.splash;

import by.vit.boombony.screens.ScreenManager;
import by.vit.boombony.screens.AbstractScreen;
import by.vit.boombony.screens.menu.MenuScreen;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

/**
 * Splash сцена. Просто первый скрин при старте,
 * на котором будет отображено лого - после этого идет меню.
 */
public class SplashScreen extends AbstractScreen<SplashTxLibrary> {
    private final ScreenManager screenManager;
    private Sprite splashLabel;
    private SpriteBatch batch;
    private boolean timerInProgress = false;
    private static final int SPLASH_SCREEN_DELAY = 0;//todo

    public SplashScreen(ScreenManager screenManager) {
        super(new SplashTxLibrary());
        loadTx();
        this.screenManager = screenManager;
        this.batch = screenManager.getGame().getBatch();
    }

    @Override
    public void show() {
        // как только показали скрин Splash сразу начинаем загрузку след. скрин.
        splashLabel = new Sprite(txLibrary.splashLabelTextureRegion);
        splashLabel.setPosition(centerWidth(splashLabel), centerHeight(splashLabel));
        this.screenManager.init();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        splashLabel.draw(batch);
        batch.end();

        if (!timerInProgress) {
            timerInProgress = true;

            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    screenManager.show(new MenuScreen(screenManager));
                }

            }, SplashScreen.SPLASH_SCREEN_DELAY);

        }/* else if (Gdx.input.isTouched()) {
            // Remove the task so we don't call changeScreen twice:
            Timer.instance().clear();
            this.screenManager.show(new MenuScreen(this.screenManager));
        }*/
    }
}
