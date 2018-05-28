package by.vit.boombony.gameobjects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class TextureButton extends Actor {
    private TextureRegion textureRegion;


    public TextureButton(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }


    public TextureButton(TextureRegion textureRegion, float x, float y) {
        this(textureRegion);
        setPosition(x, y);
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
    }

    @Override
    public void draw(Batch batch, float parentAlfa) {
        batch.draw(textureRegion, getX(), getY(), textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }
}
