package by.vit.boombony.screens.world;

import by.vit.boombony.events.ClickListener;
import by.vit.boombony.gameobjects.TextureButton;
import by.vit.boombony.gameworld.ActType;
import by.vit.boombony.gameworld.WorldState;
import by.vit.boombony.screens.AbstractStage;

public class HUDStage extends AbstractStage<HUDTxLibrary> {
    private TextureButton nextStep;

    public HUDStage() {
        super(new HUDTxLibrary());
    }

    @Override
    public void init() {
        nextStep = new TextureButton(txLibrary.nextStep, 30, 30);
        nextStep.addListener(new ClickListener() {
            @Override
            public void onClick() {
                ActType actType = WorldState.get().nextAct();

                if (actType == ActType.ENEMY) {
                    nextStep.setTextureRegion(txLibrary.nextStepDisabled);
                } else {
                    nextStep.setTextureRegion(txLibrary.nextStep);
                }
            }
        });

        addActor(nextStep);
    }
}
