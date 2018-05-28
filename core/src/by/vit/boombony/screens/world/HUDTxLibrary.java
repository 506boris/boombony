package by.vit.boombony.screens.world;

import by.vit.boombony.gameworld.AbstractTxLibrary;
import by.vit.boombony.gameworld.Scenario;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class HUDTxLibrary extends AbstractTxLibrary {
    public TextureRegion nextStep;
    public TextureRegion nextStepDisabled;

    @Override
    public void load(Scenario scenario) {
        nextStep = new TextureRegion(texture("button/next_step.png"), 0, 0, 53, 54);
        nextStepDisabled = new TextureRegion(texture("button/next_step_disabled.png"), 0, 0, 53, 54);
    }
}
