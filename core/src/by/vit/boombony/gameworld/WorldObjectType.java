package by.vit.boombony.gameworld;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import by.vit.boombony.helpers.Coo;

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

    public static boolean isTransit(TiledMapTileLayer layer, Coo coo) {
        return isTransit(layer.getCell(coo.x, coo.y));
    }

    public static boolean isStep(TiledMapTileLayer.Cell cell) {
        if (cell == null || cell.getTile() == null) {
            return false;
        }
        WorldObjectType type = getWorldObjectType(cell);
        return WorldObjectType.STEP == type;
    }

    public static boolean isCursor(TiledMapTileLayer.Cell cell) {
        if (cell == null || cell.getTile() == null) {
            return false;
        }
        WorldObjectType type = getWorldObjectType(cell);
        return WorldObjectType.CURSOR == type;
    }

    public static boolean canCommunicate(TiledMapTileLayer.Cell cell) {
        if (cell == null || cell.getTile() == null) {
            return false;
        }
        WorldObjectType type = getWorldObjectType(cell);
        return type.isCanCommunicate();
    }

    public static boolean canCommunicate(TiledMapTileLayer layer, Coo coo) {
        return canCommunicate(layer.getCell(coo.x, coo.y));
    }

    private static WorldObjectType getWorldObjectType(TiledMapTileLayer.Cell cell) {
        Object o = cell.getTile().getProperties().get(TYPE);
        if (o == null) {
            return WorldObjectType.NONE;
        }
        return WorldObjectType.valueOf(String.valueOf(o));
    }
}
