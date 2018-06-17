package by.vit.boombony.common.sprites;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BaseBackground extends Sprite {

    public BaseBackground(TextureRegion region) {
        super(region);
        this.setPosition(0, 0);
        this.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }
}
