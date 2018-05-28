package by.vit.boombony.screens.map;

import by.vit.boombony.gameworld.AbstractTxLibrary;
import by.vit.boombony.gameworld.Scenario;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MapTxLibrary extends AbstractTxLibrary {
    public TextureRegion bg;

    @Override
    public void load(Scenario scenario) {
        bg = new TextureRegion(texture("back/loadingscreen.png"), 0, 0, 800, 480);
    }
}
