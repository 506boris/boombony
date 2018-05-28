package by.vit.boombony.gameobjects;

import by.vit.boombony.gameworld.WorldObjectType;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Bomb extends WorldObject {
    public Bomb(TextureRegion texturePerson) {
        super(texturePerson, WorldObjectType.BOMB);
    }
}