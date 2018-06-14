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

        ImageButton.ImageButtonStyle okButtonStyle = new ImageButton.ImageButtonStyle();
        TextureRegion okButtonRegion = params.getEnabledOkButtonRegion();
        okButtonStyle.imageUp = new TextureRegionDrawable(okButtonRegion);
        okButtonStyle.imageDown = new TextureRegionDrawable(params.getPressedOkButtonRegion());

        Button closeButton = new ImageButton(okButtonStyle);
        closeButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                setVisible(false);
            }
        });

        closeButton.setSize(okButtonRegion.getRegionWidth(), okButtonRegion.getRegionHeight());

        align(Align.bottom);
        add(closeButton).padBottom(DEFAULT_BUTTON_PAD).padLeft(DEFAULT_BUTTON_PAD).padRight(DEFAULT_BUTTON_PAD);

        if (Const.DEBUG) this.debug();

        setSize(getStyle().background.getMinWidth(), getStyle().background.getMinHeight());
        setClip(false);
        setTransform(true);
    }
    
    @Override
    public void init() {

        setModal(true);
        setVisible(false);
        setMovable(false);
        setPosition(CoordinateUtil.centerWidth(this), CoordinateUtil.centerHeight(this));
    }
}