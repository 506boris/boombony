package by.vit.boombony.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

import by.vit.boombony.gameworld.WorldObjectType;

public class StepCursor extends Cell {
    private StaticTiledMapTile commonCursor;
    private StaticTiledMapTile buttleCursor;

    public StepCursor(TextureRegion common, TextureRegion buttle) {
        commonCursor = new StaticTiledMapTile(common);
        buttleCursor = new StaticTiledMapTile(buttle);
        setTile(commonCursor);
        commonCursor.getProperties().put(WorldObjectType.TYPE, WorldObjectType.CURSOR);
        buttleCursor.getProperties().put(WorldObjectType.TYPE, WorldObjectType.CURSOR);
    }

    public void showCommonCursor() {
        setTile(commonCursor);
    }

    public void showBattleCursor() {
        setTile(buttleCursor);
    }
}
