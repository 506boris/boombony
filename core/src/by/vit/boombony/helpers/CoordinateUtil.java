package by.vit.boombony.helpers;

public class CoordinateUtil {

    public static Coo getCellCoordinate(int screenX, int screenY) {
        Coo coo = new Coo();
        coo.x = screenX / Const.TILE_SIZE;
        coo.y = screenY / Const.TILE_SIZE;
        return coo;
    }
}
