package by.vit.boombony;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import by.vit.boombony.screens.ScreenManager;
import by.vit.boombony.screens.splash.SplashScreen;

public class BoombonyGame extends Game {
    private SpriteBatch batch;

    @Override
    public void create() {
        System.out.println("Boombony Created!");

        batch = new SpriteBatch();
        ScreenManager screenManager = new ScreenManager(this);
        setScreen(new SplashScreen(screenManager));
    }

    @Override
    public void dispose() {
        super.dispose();
        batch.dispose();
    }

    public SpriteBatch getBatch() {
        return batch;
    }
}