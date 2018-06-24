package by.vit.boombony.common.widgets;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;

import by.vit.boombony.gameworld.Initializable;
import by.vit.boombony.helpers.Const;
import by.vit.boombony.helpers.CoordinateUtil;
import by.vit.boombony.screens.world.GlobalTxLibrary;

public class CommonDialog extends Window implements Initializable {
    private static final float DEFAULT_BUTTON_PAD = 40;
    private static final float CLOSE_RIGHT_POSITION = 30;
    private static final float CLOSE_TOP_POSITION = 100;

    public CommonDialog(DialogParams params) {
        super("", new WindowStyle(params.getBitmapFont(), params.getTitleFontColor(), new TextureRegionDrawable(params.getBackgroundRegion())));
        align(Align.bottom);

        if (Const.DEBUG) this.debug();

        setSize(getStyle().background.getMinWidth(), getStyle().background.getMinHeight());
        setClip(false);
        setTransform(true);
        setModal(true);
        setVisible(false);
        setMovable(false);
        setPosition(CoordinateUtil.centerWidth(this), CoordinateUtil.centerHeight(this));
    }

    public void activateCloseButton() {
        TextureRegion closeActive = GlobalTxLibrary.close_active;
        TextureRegion closePressed = GlobalTxLibrary.close_pressed;
        ImageButton.ImageButtonStyle closeStyle = new ImageButton.ImageButtonStyle();
        closeStyle.imageUp = new TextureRegionDrawable(closeActive);
        closeStyle.imageDown = new TextureRegionDrawable(closePressed);

        Button closeButton = new ImageButton(closeStyle);
        closeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                setVisible(false);
            }
        });
        getTitleTable().add(closeButton).padRight(CLOSE_RIGHT_POSITION).padTop(CLOSE_TOP_POSITION);
    }

    public void addButtonListener(ButtonParams params, ClickListener clickListener) {
        ImageButton.ImageButtonStyle buttonStyle = new ImageButton.ImageButtonStyle();
        TextureRegion buttonRegion = params.getEnabledButtonRegion();
        buttonStyle.imageUp = new TextureRegionDrawable(buttonRegion);
        buttonStyle.imageDown = new TextureRegionDrawable(params.getPressedButtonRegion());
        Button button = new ImageButton(buttonStyle);
        button.addListener(clickListener);
        button.setSize(buttonRegion.getRegionWidth(), buttonRegion.getRegionHeight());
        add(button).padBottom(DEFAULT_BUTTON_PAD).padLeft(DEFAULT_BUTTON_PAD).padRight(DEFAULT_BUTTON_PAD);
    }

    @Override
    public void init() {

    }
}