package by.vit.boombony.texture;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class LoadingTxLibrary extends AbstractTxLibrary {
    public TextureRegion bg;

    @Override
    public void load() {
        bg = new TextureRegion(createTexture("back/loadingscreen.png"), 0, 0, 800, 480);
    }
}
