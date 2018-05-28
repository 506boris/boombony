package by.vit.boombony.gameobjects;

import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.helpers.Coo;
import by.vit.boombony.helpers.MoveHelper;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Hero extends WorldObject {
    private static final float SPEED_TIME = .3f;
    private int maxStepCount = 5;
    private Deque<Coo> coos = new ArrayDeque();
    private float currentStepTime = 0;

    public Hero(TextureRegion texturePerson) {
        super(texturePerson, WorldObjectType.HERO);
    }

    public int getMaxStepCount() {
        return maxStepCount;
    }

    public void setMaxStepCount(int maxStepCount) {
        this.maxStepCount = maxStepCount;
    }

    public void addWalkingSteps(List<Coo> coos) {
        this.coos.addAll(coos);
        coos.clear();
    }

    public void render(float delta, final TiledMapTileLayer objectLayer) {
        if(!coos.isEmpty()) {
            if (currentStepTime > SPEED_TIME) {
                currentStepTime = 0;
                Coo coo = coos.pollLast();
                if (coo != null) {
                    MoveHelper.move(this, coo, objectLayer);
                }
            } else {
                currentStepTime = currentStepTime + delta;
            }
        }
    }
}