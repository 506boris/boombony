package by.vit.boombony.texture;

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
