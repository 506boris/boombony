package by.vit.boombony.gameworld.path;

import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.helpers.Coo;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;

import java.util.*;

public final class SearchPathUtil {
    private static SearchPathUtil instance;
    private TreeCell startCell;
    private TreeCell targetCell;
    private int w = 0;
    private int h = 0;
    private TiledMapTileLayer layer;
    private PriorityQueue<TreeCell> openSet;
    private PriorityQueue<TreeCell> closeSet;

    private static class MyComparator implements Comparator<TreeCell>{
        @Override
        public int compare(TreeCell o1, TreeCell o2) {
            if (o1.getF() == o2.getF()) {
                return 0;
            } else if (o1.getF() > o2.getF()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static SearchPathUtil get() {
        if (instance == null) {
            instance = new SearchPathUtil();
        }
        return instance;
    }

    public List<Coo> search(TiledMapTileLayer layer, Coo startCoo, Coo targetCoo) {
        this.startCell = new TreeCell(startCoo, targetCoo, null);
        this.targetCell = new TreeCell(targetCoo, targetCoo, null);
        this.w = layer.getWidth();
        this.h = layer.getHeight();
        this.layer = layer;
        this.openSet = new PriorityQueue(10, new MyComparator());
        this.closeSet = new PriorityQueue(10, new MyComparator());

        // Начинаем со стартовой точки A и добавляем ее в "открытый список" клеток, которые нужно обработать.
        // Открытый список это что-то наподобие списка покупок. В данный момент есть только один элемент в списке, но позже мы добавим еще.
        // Список содержит клетки, которые может быть находятся вдоль пути, который вы выберете, а может и нет.
        // Проще говоря, это список клеток, которые нужно проверить.
        openSet.add(this.startCell);

        process(this.startCell);

        //Дальше мы выберем одну из соседних клеток в открытом списке и практически повторим вышеописанный процесс . Но какую клетку мы выберем? Ту, у которой меньше стоимость F.

        TreeCell finishCell;

        while(true) {
            TreeCell treeCell = openSet.peek(); // ожидаем, что здесь Минимальный F

            if(treeCell.getCoo().equals(targetCoo)) {
                finishCell = treeCell;
                break;
            }

            process(treeCell);
        }

        List<Coo> coos = new ArrayList();
        TreeCell currentTreeCell = finishCell;
        while(true) {
            coos.add(currentTreeCell.getCoo());
            currentTreeCell = currentTreeCell.getParent();
            if(currentTreeCell == null) {
                break;
            }
        }

//        Gdx.app.log("SearchPathUtil", coos.toString());
        return coos;
    }

    private void process(final TreeCell cell) {
        // Ищем доступные или проходимые клетки, граничащие со стартовой точкой, игнорируя клетки со стенами, водой
        // или другой непроходимой областью. И также добавляем их в открытый список. Для каждой из этих клеток сохраняем точку A,
        // как "родительскую клетку". Эта родительская клетка важна, когда мы будем прослеживать наш путь. Это будет описано намного позже.
        addAroundCellAndPutToOpenList(cell);

        // Удаляем стартовую точку A с вашего открытого списка и добавляем ее в "закрытый список" клеток, которые вам больше не нужно проверять.
        relocateCell(cell);

    }

    private void relocateCell(final TreeCell cell) {
        openSet.remove(cell);
        closeSet.add(cell);
    }

    private void addAroundCellAndPutToOpenList(final TreeCell parent) {
        Coo coo = parent.getCoo();

        Coo cooTop = new Coo(coo.x, coo.y + 1).withCheck(w, h);
        Coo cooRight = new Coo(coo.x + 1, coo.y).withCheck(w, h);
        Coo cooBottom = new Coo(coo.x, coo.y - 1).withCheck(w, h);
        Coo cooLeft = new Coo(coo.x - 1, coo.y).withCheck(w, h);

        if (cooTop != null && WorldObjectType.isTransit(layer.getCell(cooTop.x, cooTop.y))) {
            TreeCell top = new TreeCell(cooTop, targetCell.getCoo(), parent);
            if (!closeSet.contains(top)) {
                openSet.add(top);
            }
        }
        if (cooRight != null && WorldObjectType.isTransit(layer.getCell(cooRight.x, cooRight.y))) {
            TreeCell right = new TreeCell(cooRight, targetCell.getCoo(), parent);
            if (!closeSet.contains(right)) {
                openSet.add(right);
            }
        }
        if (cooBottom != null && WorldObjectType.isTransit(layer.getCell(cooBottom.x, cooBottom.y))) {
            TreeCell bottom = new TreeCell(cooBottom, targetCell.getCoo(), parent);
            if (!closeSet.contains(bottom)) {
                openSet.add(bottom);
            }
        }
        if (cooLeft != null && WorldObjectType.isTransit(layer.getCell(cooLeft.x, cooLeft.y))) {
            TreeCell left = new TreeCell(cooLeft, targetCell.getCoo(), parent);
            if (!closeSet.contains(left)) {
                openSet.add(left);
            }
        }
    }
}