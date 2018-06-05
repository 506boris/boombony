package by.vit.boombony.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.scenes.scene2d.Actor;

import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.helpers.CellBehavior;

public class WorldObject extends Actor implements CellBehavior {
    private final TextureRegion textureRegion;
    private Cell cell = new Cell();

    public WorldObject(TextureRegion textureRegion, WorldObjectType type) {
        this.textureRegion = textureRegion;
        init();
        setObjectType(type);
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
    }

    public void setObjectType(WorldObjectType type) {
        cell.getTile().getProperties().put(WorldObjectType.TYPE, type);
    }

    public WorldObjectType getObjectType() {
        return (WorldObjectType) cell.getTile().getProperties().get(WorldObjectType.TYPE);
    }

    private void init() {
        this.cell.setTile(new StaticTiledMapTile(textureRegion));
    }

    @Override
    public Cell getCell() {
        return cell;
    }
}
