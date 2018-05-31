package by.vit.boombony.screens.world;

import by.vit.boombony.events.ClickListener;
import by.vit.boombony.gameobjects.TextureButton;
import by.vit.boombony.gameworld.ActType;
import by.vit.boombony.gameworld.WorldState;
import by.vit.boombony.screens.AbstractStage;

import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class HUDStage extends AbstractStage<HUDTxLibrary> {
    TextureButton nextStep;

    public HUDStage() {
        super(new HUDTxLibrary());
    }

    @Override
    public void init() {
        nextStep = new TextureButton(txLibrary.nextStep, 30, 30);
        nextStep.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                ActType actType = WorldState.get().nextAct();
//                nextStep.setVisible(actType != ActType.ENEMY);
//                System.out.println(actType);

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
