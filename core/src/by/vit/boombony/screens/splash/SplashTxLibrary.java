package by.vit.boombony.screens.splash;

import by.vit.boombony.gameworld.AbstractTxLibrary;
import by.vit.boombony.gameworld.Scenario;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SplashTxLibrary extends AbstractTxLibrary {
    public TextureRegion splashLabel;

    @Override
    public void load() {
        splashLabel = new TextureRegion(createTexture("back/splash_text.png"), 0, 0, 203, 114);
    }
}
