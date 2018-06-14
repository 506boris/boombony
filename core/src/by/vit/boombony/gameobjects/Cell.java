package by.vit.boombony.gameobjects;

import by.vit.boombony.helpers.Coo;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

public class Cell extends TiledMapTileLayer.Cell {
    private Coo coo;
    private WorldObject parent;

    public Coo getCoo() {
        return coo;
    }

    public void setCoo(Coo coo) {
        this.coo = coo;
    }

    public WorldObject getParent() {
        return parent;
    }

    public void setParent(WorldObject parent) {
        this.parent = parent;
    }
}
