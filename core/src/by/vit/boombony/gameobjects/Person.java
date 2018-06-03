package by.vit.boombony.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import by.vit.boombony.gameworld.WorldObjectType;

public class Person extends StaticWorldObject {
    public Person(TextureRegion texturePerson, WorldObjectType type) {
        super(texturePerson, type);
    }
}
