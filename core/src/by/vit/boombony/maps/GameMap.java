package by.vit.boombony.maps;

public class GameMap {
    private CellType[][] cells;

    public GameMap() {
    }

    public CellType[][] getCells() {
        return cells;
    }

    public void setCells(CellType[][] cells) {
        this.cells = cells;
    }

    public static CellType[][] init(int x, int y) {
        CellType[][] cells = new CellType[x][y];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                cells[i][j] = CellType.GREEN;
            }
        }

        return cells;
    }
}
