package by.vit.boombony.screens.menu;

import by.vit.boombony.gameworld.AbstractTxLibrary;
import by.vit.boombony.gameworld.Scenario;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MenuTxLibrary extends AbstractTxLibrary {
    public TextureRegion bg;
    public TextureRegion buttonGo;

    @Override
    public void load(Scenario scenario) {
        bg = new TextureRegion(texture("back/bg_screen.png"), 0, 0, 800, 480);
        buttonGo = new TextureRegion(texture("button/menu_button.png"), 0, 0, 130, 38);
    }
}
