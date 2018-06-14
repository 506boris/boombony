package by.vit.boombony.screens.world;

import by.vit.boombony.gameworld.AbstractTxLibrary;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class HUDTxLibrary extends AbstractTxLibrary {
    public TextureRegion nextStep;
    public TextureRegion nextStepDisabled;
    public TextureRegion dialogBackground;
    public TextureRegion dialogOkEnabled;
    public TextureRegion dialogOkPressed;

    @Override
    public void load() {
        nextStep = new TextureRegion(createTexture("button/next_step.png"), 53, 54);
        nextStepDisabled = new TextureRegion(createTexture("button/next_step_disabled.png"), 53, 54);
        dialogBackground = new TextureRegion(createTexture("dialog_bg_top.png"), 954, 620);
        dialogOkEnabled = new TextureRegion(createTexture("button/button_ok_enabled_2.png"), 130, 38);
        dialogOkPressed = new TextureRegion(createTexture("button/button_ok_pressed_2.png"), 130, 38);
    }
}
