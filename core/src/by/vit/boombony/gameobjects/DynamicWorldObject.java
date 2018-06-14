package by.vit.boombony.gameobjects;

import by.vit.boombony.common.map.MoveMapHelper;
import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.helpers.Coo;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public abstract class DynamicWorldObject extends WorldObject {
    private static final float SPEED_TIME = .3f;
    private float currentStepTime = 0;
    private Deque<Coo> walkingSteps = new ConcurrentLinkedDeque<>();
    private boolean canMove = false;

    public DynamicWorldObject(TextureRegion texture, WorldObjectType type) {
        super(texture, type);
    }

    public void addWalkingSteps(List<Coo> coos) {
        this.walkingSteps.addAll(coos);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (isCanMove()) {
            if (currentStepTime > SPEED_TIME) {
                currentStepTime = 0;
                MoveMapHelper.moveActor(this, walkingSteps.pollLast());
            } else {
                currentStepTime = currentStepTime + delta;
            }
        }
    }

    public void setCanMove(boolean canMove) {
        if (this.canMove && !canMove) {
            walkingSteps.clear();
        }
        this.canMove = canMove;
    }

    public boolean isCanMove() {
        return !walkingSteps.isEmpty() && canMove;
    }
}
