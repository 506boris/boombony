package by.vit.boombony.gameworld;

public class SimpleScenario implements Scenario {
    private String levelName = "";
    private String levelNumber = "";
    private String tmxMapPath = "";

    public SimpleScenario(String levelName, String levelNumber, String tmxMapPath) {
        this.levelName = levelName;
        this.levelNumber = levelNumber;
        this.tmxMapPath = tmxMapPath;
    }

    public String getLevelName() {
        return levelName;
    }

    public String getLevelNumber() {
        return levelNumber;
    }

    public String getTmxMapPath() {
        return tmxMapPath;
    }
}
