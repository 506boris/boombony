package by.vit.boombony;

import com.badlogic.gdx.Game;

import by.vit.boombony.screens.ScreenManager;
import by.vit.boombony.screens.splash.SplashScreen;

public class BoombonyGame extends Game {

	@Override
	public void create () {
		System.out.println("Boombony Created!");

		ScreenManager screenManager = new ScreenManager(this);
		setScreen(new SplashScreen(screenManager));
	}
}