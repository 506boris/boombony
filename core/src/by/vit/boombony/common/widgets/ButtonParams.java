package by.vit.boombony.common.widgets;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class ButtonParams {
    private TextureRegion enabledButtonRegion;
    private TextureRegion pressedButtonRegion;
    private TextureRegion disabledButtonRegion;

    public TextureRegion getDisabledButtonRegion() {
        return disabledButtonRegion;
    }

    public void setDisabledButtonRegion(TextureRegion disabledButtonRegion) {
        this.disabledButtonRegion = disabledButtonRegion;
    }

    public TextureRegion getEnabledButtonRegion() {
        return enabledButtonRegion;
    }

    public void setEnabledButtonRegion(TextureRegion enabledButtonRegion) {
        this.enabledButtonRegion = enabledButtonRegion;
    }

    public TextureRegion getPressedButtonRegion() {
        return pressedButtonRegion;
    }

    public void setPressedButtonRegion(TextureRegion pressedButtonRegion) {
        this.pressedButtonRegion = pressedButtonRegion;
    }
}
