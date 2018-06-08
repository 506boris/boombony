package by.vit.boombony.helpers;

import by.vit.boombony.scenario.LevelScenario;

public class ScenarioHelper {
    public static LevelScenario getScenario0() {
        LevelScenario levelScenario = new LevelScenario("Default level", "0", "maps/level1.tmx");
        return levelScenario;
    }
}
