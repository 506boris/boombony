package by.vit.boombony.screens;

import by.vit.boombony.screens.loading.LoadingScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Timer;

public class ScreenManager {
    private Game game;
    private LoadingScreen loadingScreen;

    public ScreenManager(Game game) {
        this.game = game;
    }

    public void init() {
        this.loadingScreen = new LoadingScreen();
        this.loadingScreen.loadTx();
    }

    public void show(final AbstractScreen screen) {
        Screen oldScreen = game.getScreen();

        // временно показываем скрин загрузки
        game.setScreen(loadingScreen);
        loadingScreen.hide();

        // зачищаем из старого скрина все загруженнные ресурсы
        oldScreen.dispose();

        // загружаем ресурсы для отображаемого скрина
        if (screen != null) {
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    screen.loadTx();
                    // как только загрузились текстуры показываем новый скрин
                    game.setScreen(screen);
                }
            }, 0);
        }
    }
}
