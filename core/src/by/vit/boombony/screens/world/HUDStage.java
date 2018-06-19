package by.vit.boombony.screens.world;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import by.vit.boombony.common.widgets.ButtonParams;
import by.vit.boombony.common.widgets.CommonDialog;
import by.vit.boombony.common.widgets.DialogParams;
import by.vit.boombony.gameobjects.TextureButton;
import by.vit.boombony.screens.AbstractStage;

public class HUDStage extends AbstractStage<HUDTxLibrary> {
    private TextureButton nextStep;
    private CommonDialog commonDialog;

    public HUDStage() {
        super(new HUDTxLibrary());
    }

    @Override
    public void init() {
//        nextStep = new TextureButton(txLibrary.nextStep, 30, 30);
//        nextStep.addListener(new ClickListener() {
//            @Override
//            public void onClick() {
//                ActType actType = WorldState.get().nextAct();
//
//                if (actType == ActType.ENEMY) {
//                    nextStep.setTextureRegion(txLibrary.nextStepDisabled);
//                } else {
//                    nextStep.setTextureRegion(txLibrary.nextStep);
//                }
//            }
//        });
//
//        addActor(nextStep);

        DialogParams params = new DialogParams();
        params.setBackgroundRegion(txLibrary.dialogBackground);
        params.setBitmapFont(new BitmapFont());
        params.setTitleFontColor(Color.BLACK);

        ButtonParams buttonParams = new ButtonParams();
        buttonParams.setEnabledButtonRegion(txLibrary.dialogOkEnabled);
        buttonParams.setPressedButtonRegion(txLibrary.dialogOkPressed);

        commonDialog = new CommonDialog(params);
        commonDialog.addButtonListener(buttonParams);
        addActor(commonDialog);
    }

    public CommonDialog getCommonDialog() {
        return commonDialog;
    }
}
