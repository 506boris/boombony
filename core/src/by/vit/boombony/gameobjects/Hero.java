package by.vit.boombony.gameobjects;

import by.vit.boombony.gameworld.WorldObjectType;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Hero extends DynamicWorldObject {
    private int maxStepCount = 5;

    public Hero(TextureRegion texturePerson) {
        super(texturePerson, WorldObjectType.HERO);
    }

    public int getMaxStepCount() {
        return maxStepCount;
    }

    public void setMaxStepCount(int maxStepCount) {
        this.maxStepCount = maxStepCount;
    }
}