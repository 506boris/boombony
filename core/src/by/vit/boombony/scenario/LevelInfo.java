package by.vit.boombony.scenario;

import by.vit.boombony.helpers.Coo;

public class LevelInfo {
    private String levelName;
    private int levelNumber;
    private String levelDescription;
    private Coo startPoint;
    private NpcInfo NpcInfo

    String getLevelName();

    int getLevelNumber();

    String getLevelDescription();

    /**
     * Start point on map for hero
     *
     * @return coo
     */
    Coo getStartPoint();

    NpcInfo getNpcInfo();
}
