package by.vit.boombony.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import by.vit.boombony.gameworld.WorldObjectType;

/**
 * Static (it means with movement) objects
 */
public abstract class StaticWorldObject extends WorldObject {
    public StaticWorldObject(TextureRegion texturePerson, WorldObjectType type) {
        super(texturePerson, type);
    }
}
