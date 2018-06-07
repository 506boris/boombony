package by.vit.boombony.scenario;

import by.vit.boombony.helpers.Coo;

public interface LevelInfo {
    String getLevelName();

    String getLevelNumber();

    String getLevelDescription();

    /**
     * Start point on map for hero
     *
     * @return coo
     */
    Coo getStartPoint();

    NpcInfo getNpcInfo();
}
