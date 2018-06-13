package by.vit.boombony.scenario;

import by.vit.boombony.helpers.Coo;

public class LevelInfo {
    private String levelName;
    private int levelNumber;
    private String levelDescription;
    private Coo startPoint;
    private NpcInfo NpcInfo;

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public String getLevelDescription() {
        return levelDescription;
    }

    public void setLevelDescription(String levelDescription) {
        this.levelDescription = levelDescription;
    }

    public Coo getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Coo startPoint) {
        this.startPoint = startPoint;
    }

    public by.vit.boombony.scenario.NpcInfo getNpcInfo() {
        return NpcInfo;
    }

    public void setNpcInfo(by.vit.boombony.scenario.NpcInfo npcInfo) {
        NpcInfo = npcInfo;
    }
}
