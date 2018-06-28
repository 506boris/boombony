package by.vit.boombony.screens;

import by.vit.boombony.texture.TxLibrary;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public abstract class AbstractScreen<T extends TxLibrary> implements Screen {
    protected T txLibrary;

    public AbstractScreen(T txLibrary) {
        this.txLibrary = txLibrary;
    }

    @Override
    public void dispose() {
        Gdx.input.setInputProcessor(null);
        txLibrary.dispose();
    }

    /**
     * Don't call it manually.
     */
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
    public void render(float delta) {
        Gdx.gl.glClearColor(0f / 255f, 0f / 255f, 0f / 255f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @SuppressWarnings("unchecked")
    public <T extends TxLibrary> T getTxLibrary() {
        return (T) txLibrary;
    }
}
