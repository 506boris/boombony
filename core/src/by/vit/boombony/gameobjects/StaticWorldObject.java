package by.vit.boombony.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

import by.vit.boombony.gameworld.WorldObjectType;

/**
 * Static (it means with movement) objects
 */
public abstract class StaticWorldObject extends Cell {
    private final TextureRegion texturePerson;

    public StaticWorldObject(TextureRegion texturePerson, WorldObjectType type) {
        this.texturePerson = texturePerson;
        init();
        getTile().getProperties().put(WorldObjectType.TYPE, type);
    }

    private void init() {
        this.setTile(new StaticTiledMapTile(texturePerson));
    }
}
