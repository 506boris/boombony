package by.vit.boombony.screens;

import by.vit.boombony.gameworld.TxLibrary;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public abstract class AbstractScreen implements Screen {
    private TxLibrary txLibrary;

    public AbstractScreen(TxLibrary txLibrary) {
        this.txLibrary = txLibrary;
    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
        txLibrary.dispose();
    }

    public void loadTx() {
        txLibrary.load();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @SuppressWarnings("unchecked")
    public <T> T getTxLibrary() {
        return (T) txLibrary;
    }
}
