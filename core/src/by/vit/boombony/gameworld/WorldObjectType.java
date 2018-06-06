package by.vit.boombony.gameworld;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public enum WorldObjectType {
    HERO(false, true),
    NEUTRAL(false, true),
    ALLY(false, true), // союзник
    ENEMY(false, true),
    BOMB(false),
    STEP(true),
    BRICK(false),
    STONE(false),
    GOLD_STONE(false),
    GRASS(true),
    CURSOR(true),
    NONE(true);

    /**
     * Can across the object
     */
    private boolean transit;
    private boolean canCommunicate;

    WorldObjectType(boolean transit) {
        this.transit = transit;
        this.canCommunicate = false;
    }

    WorldObjectType(boolean transit, boolean canCommunicate) {
        this.transit = transit;
        this.canCommunicate = canCommunicate;
    }

    public boolean isTransit() {
        return transit;
    }

    public boolean isCanCommunicate() {
        return canCommunicate;
    }

    public static final String TYPE = "TYPE";

    public static boolean isTransit(TiledMapTileLayer.Cell cell) {
        if (cell == null || cell.getTile() == null) {
            return true;
        }
        WorldObjectType type = getWorldObjectType(cell);
        return type.isTransit();
    }

    public static boolean canCommunicate(TiledMapTileLayer.Cell cell) {
        if (cell == null || cell.getTile() == null) {
            return false;
        }
        WorldObjectType type = getWorldObjectType(cell);
        return type.isCanCommunicate();
    }

    private static WorldObjectType getWorldObjectType(TiledMapTileLayer.Cell cell) {
        return WorldObjectType.valueOf(String.valueOf(cell.getTile().getProperties().get(TYPE)));
    }
}
