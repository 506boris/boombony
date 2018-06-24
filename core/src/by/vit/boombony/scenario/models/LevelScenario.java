package by.vit.boombony.scenario.models;

public class LevelScenario {
    private LevelInfo levelInfo;
    private String tmxMapPath;

    public LevelScenario() {
    }

    public LevelScenario(LevelInfo levelInfo, String tmxMapPath) {
        this.levelInfo = levelInfo;
        this.tmxMapPath = tmxMapPath;
    }

    public String getTmxMapPath() {
        return tmxMapPath;
    }

    public LevelInfo getLevelInfo() {
        return levelInfo;
    }

    public void setTmxMapPath(String tmxMapPath) {
        this.tmxMapPath = tmxMapPath;
    }

    public void setLevelInfo(LevelInfo levelInfo) {
        this.levelInfo = levelInfo;
    }
}
