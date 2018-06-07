package by.vit.boombony.scenario;

public class SimpleLevelScenario implements LevelScenario {
    private String levelName = "";
    private String levelNumber = "";
    private String tmxMapPath = "";

    public SimpleLevelScenario(String levelName, String levelNumber, String tmxMapPath) {
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

    @Override
    public LevelInfo getLevelInfo() {
        return null;
    }
}
