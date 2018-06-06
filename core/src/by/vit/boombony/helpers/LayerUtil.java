package by.vit.boombony.helpers;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class LayerUtil {
    public static TiledMapTileLayer.Cell getCell(TiledMapTileLayer layer, Coo coo) {
        return layer.getCell(coo.x, coo.y);
    }
}
