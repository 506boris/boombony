package by.vit.boombony.screens.loading;

import by.vit.boombony.screens.AbstractScreen;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LoadingScreen extends AbstractScreen {
    private SpriteBatch batch;
    private Sprite bgSprite;

    public LoadingScreen() {
        super(new LoadingTxLibrary());
    }

    @Override
    public void show() {
        batch = new SpriteBatch();

        LoadingTxLibrary txLibrary = getTxLibrary();
        bgSprite = new Sprite(txLibrary.bg);
        bgSprite.setPosition(0, 0);
    }


    @Override
    public void render(float delta) {
        batch.begin();
        bgSprite.draw(batch);
        batch.end();
    }
}

