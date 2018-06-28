package by.vit.boombony.texture;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class HUDTxLibrary extends AbstractTxLibrary {
    public TextureRegion dialogBackground;
    public TextureRegion dialogOkEnabled;
    public TextureRegion dialogOkPressed;

    @Override
    public void load() {
        dialogBackground = new TextureRegion(createTexture("dialog_bg_top.png"), 954, 620);
        dialogOkEnabled = new TextureRegion(createTexture("button/button_ok_enabled_2.png"), 130, 38);
        dialogOkPressed = new TextureRegion(createTexture("button/button_ok_pressed_2.png"), 130, 38);
    }
}
