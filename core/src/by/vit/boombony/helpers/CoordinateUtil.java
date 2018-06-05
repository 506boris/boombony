package by.vit.boombony.helpers;

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
}
