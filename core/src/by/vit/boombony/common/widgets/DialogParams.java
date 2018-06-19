package by.vit.boombony.common.widgets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class DialogParams {
    private TextureRegion backgroundRegion;
    private BitmapFont bitmapFont;
    private Color titleFontColor;

    public TextureRegion getBackgroundRegion() {
        return backgroundRegion;
    }

    public void setBackgroundRegion(TextureRegion backgroundRegion) {
        this.backgroundRegion = backgroundRegion;
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
