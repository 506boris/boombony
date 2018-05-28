package by.vit.boombony.gameobjects;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.tiles.StaticTiledMapTile;

public class StepCursor extends BCell {
    public StepCursor(TextureRegion textureRegion) {
        setTile(new StaticTiledMapTile(textureRegion));
    }
}
