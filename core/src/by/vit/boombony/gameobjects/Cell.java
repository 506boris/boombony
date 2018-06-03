package by.vit.boombony.gameobjects;

import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.helpers.Coo;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class Cell extends TiledMapTileLayer.Cell implements HasWorldObjectType {
    private Coo coo;

    public Coo getCoo() {
        return coo;
    }

    public void setCoo(Coo coo) {
        this.coo = coo;
    }

    @Override
    public WorldObjectType getObjectType() {
        return WorldObjectType.NONE;
    }
}
