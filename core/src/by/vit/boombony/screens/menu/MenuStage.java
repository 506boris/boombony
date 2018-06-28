package by.vit.boombony.screens.menu;

import by.vit.boombony.events.ClickListener;
import by.vit.boombony.gameobjects.TextureButton;
import by.vit.boombony.screens.AbstractStage;
import by.vit.boombony.texture.TxLibraryPack;

import com.badlogic.gdx.Gdx;

public class MenuStage extends AbstractStage {
    private TextureButton startGameButton;
    private MenuScreenView screenView;

    @Override
    public void init() {
        startGameButton = new TextureButton(TxLibraryPack.get().tx("menu_button"), Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);

        startGameButton.addListener(new ClickListener() {
            @Override
            public void onClick() {
                screenView.startGame();
            }
        });

        addActor(startGameButton);
    }

    public void setScreenView(MenuScreenView screenView) {
        this.screenView = screenView;
    }
}
