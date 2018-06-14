package by.vit.boombony.screens.world;

import by.vit.boombony.gameobjects.WorldObject;

public interface WorldObjectBehavior {
    void collision(WorldObject initiator, WorldObject target);
}
