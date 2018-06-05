package by.vit.boombony.helpers;

/**
 * Object contain x and y cell coordinate. Simple object. It is just number of cells.
 * For example first cell with x=0 and y=0 coordinates. Next x=1 y=1 -> it means real coordinate is x=1*CELL_W y=1*CELL_H
 */
public class Coo {
    public int x;
    public int y;

    public Coo() {
    }

    public Coo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coo zero() {
        return new Coo(0, 0);
    }

    public Coo withCheck(int w, int h) {
        if (x < 0 || x > h - 1 || y < 0 || y > w - 1) {
            return null;
        }
        return this;
    }

    @Override
    public String toString() {
        return "[" + x + "," + y + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coo coo = (Coo) o;

        if (x != coo.x) return false;
        if (y != coo.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
