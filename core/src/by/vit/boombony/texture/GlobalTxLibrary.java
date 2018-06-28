package by.vit.boombony.texture;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class GlobalTxLibrary extends BaseTxLibrary {
    private static final String GLOBAL_TAG = "global/";
    public static TextureRegion close_active;
    public static TextureRegion close_disabled;
    public static TextureRegion close_pressed;

    @Override
    public void load() {
        close_active = createTextureRegion(GLOBAL_TAG, "close_active.png", 60, 40);
        close_disabled = createTextureRegion(GLOBAL_TAG, "close_disabled.png", 60, 40);
        close_pressed = createTextureRegion(GLOBAL_TAG, "close_pressed.png", 60, 40);
    }
}
