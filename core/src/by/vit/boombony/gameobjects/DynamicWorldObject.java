package by.vit.boombony.gameobjects;

import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.helpers.Coo;
import by.vit.boombony.helpers.MoveHelper;
import by.vit.boombony.screens.world.WorldObjectUtil;
import by.vit.boombony.screens.world.WorldTxLibrary;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

public abstract class DynamicWorldObject extends WorldObject {
    private static final float SPEED_TIME = .3f;
    private float currentStepTime = 0;
    private Deque<Coo> walkingSteps = new ConcurrentLinkedDeque<>();
    private boolean canMove = false;
    private TiledMapTileLayer defaultMapLayer = WorldTxLibrary.OBJECTS_LAYER;
    private TiledMapTileLayer cursorMapLayer = WorldTxLibrary.CURSOR_LAYER;

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
                Coo coo = walkingSteps.pollLast();

                // if cell contains any object we can not remove it silently, current decision - stop moving
                TiledMapTileLayer.Cell cell = cursorMapLayer.getCell(coo.x, coo.y);

                // we should move only by built steps
                if (WorldObjectType.isStep(cell)) {
                    MoveHelper.move(this, coo, defaultMapLayer);
                    WorldObjectUtil.clearCursorLayer(coo);
                }

                // if the last cell is cursor and this cell is transit on OBJECT layer we can do last step
                if (WorldObjectType.isCursor(cell)) {
                    WorldObjectUtil.clearCursorLayer(coo);
                    if (WorldObjectType.isTransit(defaultMapLayer, coo)) {
                        MoveHelper.move(this, coo, defaultMapLayer);
                    }
                }
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
