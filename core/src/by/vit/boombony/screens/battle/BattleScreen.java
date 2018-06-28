package by.vit.boombony.screens.battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import by.vit.boombony.common.sprites.BaseBackground;
import by.vit.boombony.gameobjects.WorldObject;
import by.vit.boombony.screens.AbstractScreen;
import by.vit.boombony.screens.ScreenManager;
import by.vit.boombony.texture.TexturePack;
import by.vit.boombony.texture.TxLibraryPack;

public class BattleScreen extends AbstractScreen {
    private SpriteBatch batch;
    private ScreenManager screenManager;
    private WorldObject initiator;
    private WorldObject target;
    private BattleStage battleStage;
    private BaseBackground bgSprite;

    public BattleScreen(ScreenManager screenManager, WorldObject initiator, WorldObject target) {
        this.screenManager = screenManager;
        this.initiator = initiator;
        this.target = target;
        this.battleStage = new BattleStage(screenManager);
    }

    @Override
    public void show() {
        batch = screenManager.getGame().getBatch();
        bgSprite = new BaseBackground(TxLibraryPack.get().tx("battle_screen"));
        battleStage.init();

        Gdx.input.setInputProcessor(battleStage);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        bgSprite.draw(batch);
        batch.end();
        battleStage.render(delta);
        battleStage.draw();
    }

    @Override
    public void loadTx() {
        TxLibraryPack.get().loadTx(TexturePack.BATTLE);
    }

    @Override
    public void dispose() {
        super.dispose();
        TxLibraryPack.get().dispose(TexturePack.BATTLE);
    }
}
