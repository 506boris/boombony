package by.vit.boombony.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import by.vit.boombony.gameworld.WorldObjectType;

/**
 * Non-Player Character
 */
public class NPC extends StaticWorldObject {
    public NPC(TextureRegion texturePerson, WorldObjectType type) {
        super(texturePerson, type);
    }
}
