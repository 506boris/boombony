package by.vit.boombony.helpers;

import by.vit.boombony.scenario.LevelScenario;
import by.vit.boombony.scenario.SimpleLevelScenario;

public class ScenarioHelper {
    public static LevelScenario getScenario0() {
        LevelScenario levelScenario = new SimpleLevelScenario("Default level", "0", "maps/level1.tmx");
        return levelScenario;
    }
}
