package by.vit.boombony.helpers;

import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonWriter;

import by.vit.boombony.scenario.models.LevelScenario;
import by.vit.boombony.scenario.maker.GdxFileLoader;

public class ScenarioManager {

    private static final Json JSON = new Json();

    static {
        JSON.setOutputType(JsonWriter.OutputType.json);
    }

    public static LevelScenario getScenario0() {

        String json = GdxFileLoader.read("scenarios/level1.json");
        return JSON.fromJson(LevelScenario.class, json);
    }
}
