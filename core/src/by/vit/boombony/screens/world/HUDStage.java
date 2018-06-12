package by.vit.boombony.screens.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;

import by.vit.boombony.events.ClickListener;
import by.vit.boombony.gameobjects.Dialog;
import by.vit.boombony.gameobjects.TextureButton;
import by.vit.boombony.gameworld.ActType;
import by.vit.boombony.gameworld.WorldState;
import by.vit.boombony.helpers.CoordinateUtil;
import by.vit.boombony.screens.AbstractStage;
import by.vit.boombony.screens.ScreenManager;

public class HUDStage extends AbstractStage<HUDTxLibrary> implements HUD {
    private TextureButton nextStep;
    private Dialog dialogPanel;
    private boolean showDialog = false;
    CommonDialog commonDialog;
    ScreenManager screenManager;

    public HUDStage(ScreenManager screenManager) {
        super(new HUDTxLibrary());
        this.screenManager = screenManager;
    }

    @Override
    public void init() {

        commonDialog = new CommonDialog();
        commonDialog.setSize(400, 300);
        commonDialog.setModal(true);
        commonDialog.setVisible(true);
        commonDialog.setMovable(true);
        commonDialog.setPosition(Gdx.graphics.getWidth() / 2 - commonDialog.getWidth() / 2, Gdx.graphics.getHeight() / 2 - commonDialog.getHeight() / 2);

        addActor(commonDialog);


        nextStep = new TextureButton(txLibrary.nextStep, 30, 30);
        nextStep.addListener(new ClickListener() {
            @Override
            public void onClick() {
                ActType actType = WorldState.get().nextAct();

                commonDialog.setVisible(!showDialog);

//                dialog(!showDialog, "Message");
//                showDialog = !showDialog;

                if (actType == ActType.ENEMY) {
                    nextStep.setTextureRegion(txLibrary.nextStepDisabled);
                } else {
                    nextStep.setTextureRegion(txLibrary.nextStep);
                }
            }
        });

        addActor(nextStep);

//        dialogPanel = new Dialog(txLibrary.dialogBackground);
//        dialogPanel.setZIndex(1);
//        dialogPanel.setPosition(CoordinateUtil.centerWidth(dialogPanel), CoordinateUtil.centerHeight(dialogPanel));
//        dialogPanel.setVisible(false);
//        addActor(dialogPanel);

    }

    @Override
    public void dialog(boolean show, String message) {
//        dialogPanel.setText(message);
//        dialogPanel.setVisible(show);

    }
}
