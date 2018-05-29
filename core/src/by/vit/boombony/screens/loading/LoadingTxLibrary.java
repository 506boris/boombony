package by.vit.boombony.screens.loading;

import by.vit.boombony.gameworld.AbstractTxLibrary;
import by.vit.boombony.gameworld.Scenario;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class LoadingTxLibrary extends AbstractTxLibrary {
    public TextureRegion bg;

    @Override
    public void load() {
        bg = new TextureRegion(createTexture("back/loadingscreen.png"), 0, 0, 800, 480);
    }
}
