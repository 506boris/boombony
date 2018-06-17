package by.vit.boombony.screens.battle;

import by.vit.boombony.helpers.ScenarioHelper;
import by.vit.boombony.screens.AbstractStage;
import by.vit.boombony.screens.ScreenManager;
import by.vit.boombony.screens.world.WorldScreen;

public class BattleStage extends AbstractStage<BattleTxLibrary> {
    private ScreenManager screenManager;

    public BattleStage(ScreenManager screenManager, BattleTxLibrary txLibrary) {
        super(txLibrary);
        this.screenManager = screenManager;
    }

    @Override
    public void init() {

    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        super.touchUp(screenX, screenY, pointer, button);

        screenManager.show(new WorldScreen(screenManager, ScenarioHelper.getScenario0()));
        return true;
    }
}
