package by.vit.boombony.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;
import com.badlogic.gdx.scenes.scene2d.Actor;

import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.helpers.CellBehavior;
import by.vit.boombony.screens.world.CollisionActionType;
import by.vit.boombony.screens.world.WorldObjectBehavior;

public class WorldObject extends Actor implements CellBehavior {
    private final TextureRegion textureRegion;
    private Cell cell = new Cell();
    private WorldObjectBehavior worldObjectBehavior;
    private CollisionActionType collisionActionType = CollisionActionType.NONE;

    public WorldObject(TextureRegion textureRegion, WorldObjectType type) {
        this.textureRegion = textureRegion;
        init();
        setObjectType(type);
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
        cell.setParent(this);
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

    public void doAction(WorldObject initiator) {
        if (worldObjectBehavior != null) {
            worldObjectBehavior.collision(initiator, this);
        }
    }

    public void setWorldObjectBehavior(WorldObjectBehavior worldObjectBehavior) {
        this.worldObjectBehavior = worldObjectBehavior;
    }

    public CollisionActionType getCollisionActionType() {
        return collisionActionType;
    }

    public void setCollisionActionType(CollisionActionType collisionActionType) {
        this.collisionActionType = collisionActionType;
    }

    @Override
    public Cell getCell() {
        return cell;
    }
}
