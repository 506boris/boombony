package by.vit.boombony.screens.world;

import by.vit.boombony.gameobjects.WorldObject;
import by.vit.boombony.helpers.Const;

import com.badlogic.gdx.graphics.Camera;

public final class CameraHelper {

    public static void followCamera(Camera camera, WorldObject worldObject, int mapWidth, int mapHeight) {
        float cameraX = worldObject.getCoo().x * Const.TILE_SIZE;
        float cameraY = worldObject.getCoo().y * Const.TILE_SIZE;

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

        /**
         * If x = 0 and y = 0 it means camera will be centered
         */
        camera.position.set(cameraX, cameraY, 0);
        camera.update();
    }
}
