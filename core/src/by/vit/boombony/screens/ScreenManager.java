package by.vit.boombony.screens;

import by.vit.boombony.BoombonyGame;
import by.vit.boombony.screens.loading.LoadingScreen;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Timer;

public class ScreenManager {
    private BoombonyGame game;
    private LoadingScreen loadingScreen;

    public ScreenManager(BoombonyGame game) {
        this.game = game;
    }

    public void init() {
        this.loadingScreen = new LoadingScreen();
        this.loadingScreen.loadTx();
    }

    public void show(AbstractScreen newScreen) {
        if (newScreen != null) {
            Screen oldScreen = game.getScreen();

            // временно показываем скрин загрузки
            game.setScreen(loadingScreen);
            loadingScreen.show();

            // зачищаем из старого скрина все загруженнные ресурсы
            oldScreen.dispose();

            // загружаем ресурсы для отображаемого скрина
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    newScreen.loadTx();
                    // как только загрузились текстуры показываем новый скрин
                    game.setScreen(newScreen);
                }
            }, 1);// 1 it is just delay beetwen loading resources
        }
    }

    public BoombonyGame getGame() {
        return game;
    }
}
