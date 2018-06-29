package by.vit.boombony.screens.loading;

import by.vit.boombony.screens.AbstractScreen;
import by.vit.boombony.texture.TexturePack;
import by.vit.boombony.texture.TxLibraryPack;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LoadingScreen extends AbstractScreen {
    private SpriteBatch batch;
    private Sprite bgSprite;

    @Override
    public void show() {
        batch = new SpriteBatch();

        bgSprite = TxLibraryPack.sprite("loadingscreen");
        bgSprite.setPosition(0, 0);
        bgSprite.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    @Override
    public void loadTx() {
        TxLibraryPack.loadTx(TexturePack.GLOBAL);
    }

    @Override
    public void render(float delta) {
        batch.begin();
        bgSprite.draw(batch);
        batch.end();
    }
}

