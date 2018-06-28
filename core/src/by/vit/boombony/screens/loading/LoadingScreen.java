package by.vit.boombony.screens.loading;

import by.vit.boombony.screens.AbstractScreen;
import by.vit.boombony.texture.LoadingTxLibrary;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LoadingScreen extends AbstractScreen<LoadingTxLibrary> {
    private SpriteBatch batch;
    private Sprite bgSprite;

    public LoadingScreen() {
        super(new LoadingTxLibrary());
    }

    @Override
    public void show() {
        batch = new SpriteBatch();

        bgSprite = new Sprite(txLibrary.bg);
        bgSprite.setPosition(0, 0);
        bgSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }


    @Override
    public void render(float delta) {
        batch.begin();
        bgSprite.draw(batch);
        batch.end();
    }
}

