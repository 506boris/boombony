package by.vit.boombony.helpers;

import by.vit.boombony.gameworld.Scenario;
import by.vit.boombony.gameworld.SimpleScenario;

public class ScenarioHelper {
    public static Scenario getScenario0() {
        Scenario scenario = new SimpleScenario("Default level", "0", "maps/level0.tmx");
        return scenario;
    }
}
