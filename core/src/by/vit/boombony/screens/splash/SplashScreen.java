package by.vit.boombony.screens.splash;

import by.vit.boombony.screens.ScreenManager;
import by.vit.boombony.screens.AbstractScreen;
import by.vit.boombony.screens.menu.MenuScreen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

/**
 * Splash сцена. Ожидается что это будет просто первый скрин при старте,
 * на котором будет отображено лого - после этого идет меню.
 */
public class SplashScreen extends AbstractScreen {
    private final ScreenManager screenManager;
    private Sprite sprite;
    private SpriteBatch batch;
    private boolean timerIsOn = false;
    private static final int SPLASH_SCREEN_DELAY = 1;

    public SplashScreen(ScreenManager screenManager) {
        super(new SplashTxLibrary());
        this.screenManager = screenManager;
        this.batch = new SpriteBatch();
        loadTx();
    }

    @Override
    public void show() {
        // как только показали скрин Splash сразу начинаем загрузку след. скрин.


        SplashTxLibrary txLibrary = getTxLibrary();
        sprite = new Sprite(txLibrary.splashLabel);
        sprite.setPosition(200, 150);
        this.screenManager.init();
    }

    @Override
    public void render(float delta) {
        batch.begin();
        sprite.draw(batch);
        batch.end();

        if (!timerIsOn) {
            timerIsOn = true;

            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    screenManager.show(new MenuScreen(screenManager));
                }

            }, SplashScreen.SPLASH_SCREEN_DELAY);

        } else if (Gdx.input.isTouched()) {
            // Remove the task so we don't call changeScreen twice:
            Timer.instance().clear();
            this.screenManager.show(new MenuScreen(this.screenManager));
        }
    }


}
