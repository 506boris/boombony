package by.vit.boombony.scenario;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.google.gson.Gson;

public class ScenarioHelper {
    private static final String SCENARIO_SUFFIX = "scenarios/level_";

    public static LevelScenario loadScenarioByNumber(int number) {

        FileHandle fileHandle = Gdx.files.internal(SCENARIO_SUFFIX + number);
        LevelScenario levelScenario = new LevelScenario();
//        Gson gson = new Gson();
//        gson.toJson(levelScenario, fileHandle.file());
        return null;
    }
}
