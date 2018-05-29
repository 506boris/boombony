package by.vit.boombony.screens.menu;

import by.vit.boombony.gameworld.AbstractTxLibrary;
import by.vit.boombony.gameworld.Scenario;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MenuTxLibrary extends AbstractTxLibrary {
    public TextureRegion bg;
    public TextureRegion buttonGo;

    @Override
    public void load() {
        bg = new TextureRegion(createTexture("back/bg_screen.png"), 0, 0, 800, 480);
        buttonGo = new TextureRegion(createTexture("button/menu_button.png"), 0, 0, 130, 38);
    }
}
