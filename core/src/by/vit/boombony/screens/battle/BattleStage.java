package by.vit.boombony.screens.battle;

import by.vit.boombony.helpers.ScenarioManager;
import by.vit.boombony.screens.AbstractStage;
import by.vit.boombony.screens.ScreenManager;
import by.vit.boombony.screens.world.WorldScreen;

public class BattleStage extends AbstractStage {
    private ScreenManager screenManager;

    public BattleStage(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    @Override
    public void init() {

    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        super.touchUp(screenX, screenY, pointer, button);

        screenManager.show(new WorldScreen(screenManager, ScenarioManager.getScenario0()));
        return true;
    }
}
