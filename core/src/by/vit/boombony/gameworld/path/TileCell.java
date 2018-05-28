package by.vit.boombony.gameworld.path;

import by.vit.boombony.helpers.Coo;

public class TileCell {
    private Coo coo;
    private TileCellType type = TileCellType.EMPTY;

    public TileCell(Coo coo) {
        this.coo = coo;
    }

    public Coo getCoo() {
        return coo;
    }

    public TileCellType getType() {
        return type;
    }

    public void setType(TileCellType type) {
        this.type = type;
    }
}
