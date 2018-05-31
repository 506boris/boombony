package by.vit.boombony.gameobjects;

import by.vit.boombony.gameworld.WorldObjectType;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

public abstract class WorldObject extends Cell {
    private final TextureRegion texturePerson;

    public WorldObject(TextureRegion texturePerson, WorldObjectType type) {
        this.texturePerson = texturePerson;
        init();
        getTile().getProperties().put(WorldObjectType.TYPE, type);
    }

    private void init() {
        this.setTile(new StaticTiledMapTile(texturePerson));
    }
}
