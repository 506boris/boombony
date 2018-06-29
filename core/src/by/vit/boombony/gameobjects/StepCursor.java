package by.vit.boombony.gameobjects;

import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.texture.TxLibraryPack;

public class StepCursor extends Cell {
    private StaticTiledMapTile commonCursor;
    private StaticTiledMapTile buttleCursor;

    public StepCursor() {
        commonCursor = new StaticTiledMapTile(TxLibraryPack.tx("activecell"));
        buttleCursor = new StaticTiledMapTile(TxLibraryPack.tx("activecell_attack"));
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
