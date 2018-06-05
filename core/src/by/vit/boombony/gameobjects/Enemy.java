package by.vit.boombony.gameobjects;

import by.vit.boombony.gameworld.WorldObjectType;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Enemy extends DynamicWorldObject {
    public Enemy(TextureRegion textureRegion) {
        super(textureRegion, WorldObjectType.ENEMY);
    }
}
