package by.vit.boombony.screens.world;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import by.vit.boombony.common.widgets.CommonDialog;
import by.vit.boombony.common.widgets.DialogParams;
import by.vit.boombony.events.ClickListener;
import by.vit.boombony.gameobjects.TextureButton;
import by.vit.boombony.gameworld.ActType;
import by.vit.boombony.gameworld.WorldState;
import by.vit.boombony.screens.AbstractStage;

public class HUDStage extends AbstractStage<HUDTxLibrary> {
    private TextureButton nextStep;
    private CommonDialog commonDialog;

    public HUDStage() {
        super(new HUDTxLibrary());
    }

    @Override
    public void init() {
        DialogParams params = new DialogParams();
        params.setBackgroundRegion(txLibrary.dialogBackground);
        params.setEnabledOkButtonRegion(txLibrary.dialogOkEnabled);
        params.setPressedOkButtonRegion(txLibrary.dialogOkPressed);
        params.setBitmapFont(new BitmapFont());
        params.setTitleFontColor(Color.BLACK);

        commonDialog = new CommonDialog(params);
        commonDialog.init();
        addActor(commonDialog);

        nextStep = new TextureButton(txLibrary.nextStep, 30, 30);
        nextStep.addListener(new ClickListener() {
            @Override
            public void onClick() {
                ActType actType = WorldState.get().nextAct();

                commonDialog.setVisible(true);

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
