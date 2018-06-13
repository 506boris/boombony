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
import by.vit.boombony.helpers.CoordinateUtil;

public class CommonDialog extends Window implements Initializable {

    public CommonDialog(DialogParams params) {
        super("Hello title here", new WindowStyle(params.getBitmapFont(), params.getTitleFontColor(), new TextureRegionDrawable(params.getBackgroundRegion())));

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
        add(closeButton).padBottom(40).padLeft(40).padRight(40);

//        this.debug();


        setClip(false);
        setTransform(true);
    }

    @Override
    public void init() {

        this.setSize(getStyle().background.getMinWidth(), getStyle().background.getMinHeight());
        this.setModal(true);
        this.setVisible(false);
        this.setMovable(false);
        this.setPosition(CoordinateUtil.centerWidth(this), CoordinateUtil.centerHeight(this));

//        this.right().bottom();
    }
}