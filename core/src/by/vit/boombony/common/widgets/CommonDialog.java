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

public class CommonDialog extends Window implements Initializable {
    private static final float DEFAULT_BUTTON_PAD = 40;

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

    public void addButtonListener(ButtonParams buttonParams) {
        addButtonListener(buttonParams, new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                setVisible(false);
            }
        });
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