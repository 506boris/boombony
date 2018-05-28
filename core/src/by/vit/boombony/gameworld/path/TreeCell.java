package by.vit.boombony.gameworld.path;

import by.vit.boombony.helpers.Coo;

public class TreeCell implements Comparable<TreeCell> {
    private Coo coo;
    private TreeCell parent;
    // [start]------G------[this]------H-----[target] -> F = G + H
    private int F = 0;
    private int G = 0;

    public TreeCell(Coo coo, Coo targetCoo, TreeCell parent) {
        this.coo = coo;
        this.parent = parent;
        this.G = (parent == null ? 0 : parent.getG() + 1);
        int H = Math.abs(targetCoo.x - coo.x) + Math.abs(targetCoo.y - coo.y);
        this.F = G + H;
    }

    public int getF() {
        return F;
    }

    public void setF(int f) {
        F = f;
    }

    public int getG() {
        return G;
    }

    public void setG(int g) {
        G = g;
    }

    public Coo getCoo() {
        return coo;
    }

    public TreeCell getParent() {
        return parent;
    }

    @Override
    public int compareTo(TreeCell o) {
        if (this.getF() == o.getF()) {
            return 0;
        } else if (this.getF() > o.getF()) {
            return 1;
        } else {
            return -1;
        }
    }
}
