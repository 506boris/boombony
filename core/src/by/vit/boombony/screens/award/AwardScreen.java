package by.vit.boombony.screens.award;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import by.vit.boombony.gameobjects.Hero;
import by.vit.boombony.screens.AbstractScreen;
import by.vit.boombony.screens.ScreenManager;

public class AwardScreen extends AbstractScreen {

    private ScreenManager screenManager;
    private Hero hero;
    private HasReward reward;
    private BitmapFont font;

    @Override
    public void loadTx() {

    }

    public AwardScreen(ScreenManager screenManager, Hero hero, HasReward reward) {
        this.screenManager = screenManager;
        this.hero = hero;
        this.reward = reward;
    }

    @Override
    public void show() {

        font = new BitmapFont();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        SpriteBatch batch = screenManager.getGame().getBatch();
        batch.begin();
        font.draw(batch, "Awarding screen", Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        batch.end();
    }
}
