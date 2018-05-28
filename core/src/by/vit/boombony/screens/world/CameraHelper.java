package by.vit.boombony.screens.world;

import by.vit.boombony.gameobjects.WorldObject;
import by.vit.boombony.helpers.Const;
import com.badlogic.gdx.graphics.Camera;

public final class CameraHelper {
    public static void followCamera(Camera camera, WorldObject worldObject, int layerWidth, int layerHeight) {
        float cameraX = worldObject.getCoo().x * Const.TILE_SIZE;
        float cameraY = worldObject.getCoo().y * Const.TILE_SIZE;

        if (cameraX <= camera.viewportWidth / 2) {
            cameraX = camera.viewportWidth / 2;
        }

        if (cameraY <= camera.viewportHeight / 2) {
            cameraY = camera.viewportHeight / 2;
        }

        if (cameraX > layerWidth - camera.viewportWidth / 2) {
            cameraX = layerWidth - camera.viewportWidth / 2;
        }

        if (cameraY > layerHeight - camera.viewportHeight / 2) {
            cameraY = layerHeight - camera.viewportHeight / 2;
        }

        camera.position.set(cameraX, cameraY, 0);
        camera.update();
    }
}
