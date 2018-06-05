package by.vit.boombony.screens.splash;

import by.vit.boombony.gameworld.AbstractTxLibrary;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SplashTxLibrary extends AbstractTxLibrary {
    public TextureRegion splashLabelTextureRegion;

    @Override
    public void load() {
        splashLabelTextureRegion = new TextureRegion(createTexture("back/splash_text.png"), 0, 0, 203, 114);
    }
}
