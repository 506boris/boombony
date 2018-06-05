package by.vit.boombony.screens.world;

import by.vit.boombony.gameobjects.DynamicWorldObject;
import by.vit.boombony.helpers.Const;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.Vector3;

public final class CameraHelper {

    public static void followCamera(Camera camera, DynamicWorldObject dynamicWorldObject, int mapWidth, int mapHeight) {
        float cameraX = dynamicWorldObject.getCell().getCoo().x * Const.TILE_SIZE;
        float cameraY = dynamicWorldObject.getCell().getCoo().y * Const.TILE_SIZE;

        if (cameraX <= camera.viewportWidth / 2) {
            cameraX = camera.viewportWidth / 2;
        } else if (cameraX > mapWidth - camera.viewportWidth / 2) {
            cameraX = mapWidth - camera.viewportWidth / 2;
        }

        if (cameraY <= camera.viewportHeight / 2) {
            cameraY = camera.viewportHeight / 2;
        } else if (cameraY > mapHeight - camera.viewportHeight / 2) {
            cameraY = mapHeight - camera.viewportHeight / 2;
        }

        //If x = 0 and y = 0 it means camera will be centered
        updateCamera(camera, Const.DEFAULT_SPEED_DELTA, cameraX, cameraY);
        camera.update();
    }

    private static void updateCamera(Camera camera, float delta, float Xtaget, float Ytarget) {

        // Creating a vector 3 which represents the target location myplayer)
        Vector3 target = new Vector3(Xtaget, Ytarget, 0);
        // Change speed to your need
        float speed = delta;
        float iSpeed = 1.0f - speed;
        // The result is roughly: old_position*0.9 + target * 0.1
        Vector3 cameraPosition = camera.position;
        cameraPosition.scl(iSpeed);
        target.scl(speed);
        cameraPosition.add(target);
        camera.position.set(cameraPosition);
    }
}
