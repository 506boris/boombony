package by.vit.boombony.screens.map;

import by.vit.boombony.texture.TxLibrary;
import by.vit.boombony.screens.AbstractScreen;

public class MapScreen extends AbstractScreen {
    public MapScreen(TxLibrary txLibrary) {
        super(txLibrary);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);

    }

    @Override
    public void dispose() {
        // скрин сцену предпологаю деражть всегда в памяти, то есть не убивать ресурсы и тд.
    }
}
