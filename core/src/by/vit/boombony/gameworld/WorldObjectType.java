package by.vit.boombony.gameworld;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public enum WorldObjectType {
    HERO(false),
    NEUTRAL(false),
    ALLY(false), // союзник
    ENEMY(false),
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

    WorldObjectType(boolean transit) {
        this.transit = transit;
    }

    public boolean isTransit() {
        return transit;
    }

    public static final String TYPE = "TYPE";

    public static boolean isTransit(TiledMapTileLayer.Cell cell) {
        if (cell == null || cell.getTile() == null) {
            return true;
        }
        WorldObjectType type = WorldObjectType.valueOf(String.valueOf(cell.getTile().getProperties().get(TYPE)));
        return type.isTransit();
    }
}
