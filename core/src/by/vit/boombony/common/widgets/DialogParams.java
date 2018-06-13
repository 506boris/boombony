package by.vit.boombony.common.widgets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DialogParams {
    private TextureRegion backgroundRegion;
    private TextureRegion enabledOkButtonRegion;
    private TextureRegion pressedOkButtonRegion;
    private BitmapFont bitmapFont;
    private Color titleFontColor;

    public TextureRegion getPressedOkButtonRegion() {
        return pressedOkButtonRegion;
    }

    public void setPressedOkButtonRegion(TextureRegion pressedOkButtonRegion) {
        this.pressedOkButtonRegion = pressedOkButtonRegion;
    }

    public TextureRegion getBackgroundRegion() {
        return backgroundRegion;
    }

    public void setBackgroundRegion(TextureRegion backgroundRegion) {
        this.backgroundRegion = backgroundRegion;
    }

    public TextureRegion getEnabledOkButtonRegion() {
        return enabledOkButtonRegion;
    }

    public void setEnabledOkButtonRegion(TextureRegion enabledOkButtonRegion) {
        this.enabledOkButtonRegion = enabledOkButtonRegion;
    }

    public BitmapFont getBitmapFont() {
        return bitmapFont;
    }

    public void setBitmapFont(BitmapFont bitmapFont) {
        this.bitmapFont = bitmapFont;
    }

    public Color getTitleFontColor() {
        return titleFontColor;
    }

    public void setTitleFontColor(Color titleFontColor) {
        this.titleFontColor = titleFontColor;
    }
}
