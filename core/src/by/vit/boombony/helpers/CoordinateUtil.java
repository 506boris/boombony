package by.vit.boombony.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class CoordinateUtil {

    public static Coo getCellCenter(int screenX, int screenY) {
        Coo coo = new Coo();
        coo.x = screenX / Const.TILE_SIZE;
        coo.y = screenY / Const.TILE_SIZE;
        return coo;
    }

    public static int[] getCoordinates(Coo coo) {
        return new int[]{coo.x * Const.TILE_SIZE, coo.y * Const.TILE_SIZE};
    }

    public static float centerWidth(Actor sprite) {
        float width = Gdx.graphics.getWidth();
        float spriteWidth = sprite.getWidth();
        return width / 2 - spriteWidth / 2;
    }

    public static float centerHeight(Actor sprite) {
        float height = Gdx.graphics.getHeight();
        float spriteHeight = sprite.getHeight();
        return height / 2 - spriteHeight / 2;
    }

    public static float centerWidth(Sprite sprite) {
        float width = Gdx.graphics.getWidth();
        float spriteWidth = sprite.getWidth();
        return width / 2 - spriteWidth / 2;
    }

    public static float centerHeight(Sprite sprite) {
        float height = Gdx.graphics.getHeight();
        float spriteHeight = sprite.getHeight();
        return height / 2 - spriteHeight / 2;
    }

}
