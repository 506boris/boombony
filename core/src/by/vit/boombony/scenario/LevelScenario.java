package by.vit.boombony.scenario;

public class LevelScenario {
    private String levelName;
    private String levelNumber;
    private String tmxMapPath;
    private LevelInfo levelInfo;

    public LevelScenario() {
    }

    public LevelScenario(String levelName, String levelNumber, String tmxMapPath) {
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

    public LevelInfo getLevelInfo() {
        return levelInfo;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public void setLevelNumber(String levelNumber) {
        this.levelNumber = levelNumber;
    }

    public void setTmxMapPath(String tmxMapPath) {
        this.tmxMapPath = tmxMapPath;
    }

    public void setLevelInfo(LevelInfo levelInfo) {
        this.levelInfo = levelInfo;
    }
}
