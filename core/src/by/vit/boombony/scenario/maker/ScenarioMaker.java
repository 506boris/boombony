package by.vit.boombony.scenario.maker;

public class ScenarioMaker {
    private static final String SCENARIO_SUFFIX = "E://work/gdxlib/boombony/android/assets/scenarios/";

    public static void main(String[] args) {
        ScenarioMaker r = new ScenarioMaker();
//        r.load();

        r.save();
    }


    public void load() {
        GameMap gameMap = MapLoader.get().load("2");
        System.out.println(gameMap);
    }


    public void save() {
        String filename = "level1.json";
        String json = ScenarioJsonManager.createJsonScenario();
        FileLoader.write(SCENARIO_SUFFIX + filename, json);
    }

}
