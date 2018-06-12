package by.vit.boombony.gameobjects;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Dialog extends Actor {
    private TextureRegion textureRegion;
    private String text;
    private BitmapFont font;

    public Dialog(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
        this.font = new BitmapFont();
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void draw(Batch batch, float parentAlfa) {
        batch.draw(textureRegion, getX(), getY(), textureRegion.getRegionWidth(), textureRegion.getRegionHeight());

        if (text != null) {
            font.draw(batch, text, this.getX() + 50, this.getY() + this.getHeight() - 200);
        }
    }
}
