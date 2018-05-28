package by.vit.boombony.screens.menu;

import by.vit.boombony.events.ClickListener;
import by.vit.boombony.gameobjects.TextureButton;
import by.vit.boombony.screens.AbstractStage;
import com.badlogic.gdx.scenes.scene2d.InputEvent;

public class MenuStage extends AbstractStage<MenuTxLibrary> {
    private TextureButton startGameButton;
    private MenuScreenView screenView;

    public MenuStage(MenuTxLibrary txLibrary) {
        super(txLibrary);
    }

    @Override
    public void init() {
        startGameButton = new TextureButton(txLibrary.buttonGo, 260, 150);

        startGameButton.addListener(new ClickListener() {
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                screenView.startGame();
            }
        });

        addActor(startGameButton);
    }

    public void setScreenView(MenuScreenView screenView) {
        this.screenView = screenView;
    }
}
