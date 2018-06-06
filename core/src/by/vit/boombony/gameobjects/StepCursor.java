package by.vit.boombony.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

import by.vit.boombony.gameworld.WorldObjectType;

public class StepCursor extends Cell {
    public StepCursor(TextureRegion textureRegion) {
        setTile(new StaticTiledMapTile(textureRegion));
        getTile().getProperties().put(WorldObjectType.TYPE, WorldObjectType.CURSOR);
    }
}
