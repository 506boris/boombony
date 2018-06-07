package by.vit.boombony.screens.world;

import by.vit.boombony.gameworld.AbstractTxLibrary;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class HUDTxLibrary extends AbstractTxLibrary {
    public TextureRegion nextStep;
    public TextureRegion nextStepDisabled;

    @Override
    public void load() {
        nextStep = new TextureRegion(createTexture("button/next_step.png"), 0, 0, 53, 54);
        nextStepDisabled = new TextureRegion(createTexture("button/next_step_disabled.png"), 0, 0, 53, 54);
    }
}
