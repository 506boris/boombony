package by.vit.boombony.texture;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SplashTxLibrary extends AbstractTxLibrary {
    public TextureRegion splashLabelTextureRegion;

    @Override
    public void load() {
        splashLabelTextureRegion = new TextureRegion(createTexture("back/splash_text.png"), 0, 0, 203, 114);
    }
}
