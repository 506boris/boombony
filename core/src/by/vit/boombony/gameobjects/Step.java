package by.vit.boombony.gameobjects;

import by.vit.boombony.gameworld.WorldObjectType;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Step extends WorldObject {
    public Step(TextureRegion texturePerson) {
        super(texturePerson, WorldObjectType.STEP);
    }
}
