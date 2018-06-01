package by.vit.boombony.gameobjects;

import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.helpers.Coo;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Step extends StaticWorldObject {
    public Step(TextureRegion texturePerson, Coo coo) {
        super(texturePerson, WorldObjectType.STEP);
        this.setCoo(coo);
    }
}
