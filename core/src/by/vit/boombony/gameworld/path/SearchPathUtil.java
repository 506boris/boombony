package by.vit.boombony.gameworld.path;

import by.vit.boombony.Logger;
import by.vit.boombony.gameworld.WorldObjectType;
import by.vit.boombony.helpers.Coo;
import by.vit.boombony.helpers.LayerUtil;

import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.google.common.collect.Lists;

import java.util.*;

public final class SearchPathUtil {
    private static SearchPathUtil instance;
    private TreeCell startCell;
    private TreeCell targetCell;
    private int w = 0;
    private int h = 0;
    private TiledMapTileLayer layer;
    private PriorityQueue<TreeCell> openSet;// те обьекты которые еще нужно проверить
    private PriorityQueue<TreeCell> closeSet;// те обьекты которые уже проверялись
    private MyComparator myComparator = new MyComparator();
    private boolean searchingInProgress;

    private static class MyComparator implements Comparator<TreeCell> {
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

    public synchronized List<Coo> search(TiledMapTileLayer layer, Coo startCoo, Coo targetCoo) {
        this.searchingInProgress = true;
        this.startCell = new TreeCell(startCoo, targetCoo, null);
        this.targetCell = new TreeCell(targetCoo, targetCoo, null);
        this.w = layer.getWidth();
        this.h = layer.getHeight();
        this.layer = layer;
        this.openSet = new PriorityQueue(20, myComparator);
        this.closeSet = new PriorityQueue(20, myComparator);

        // Начинаем со стартовой точки A и добавляем ее в "открытый список" клеток, которые нужно обработать.
        // Открытый список это что-то наподобие списка покупок. В данный момент есть только один элемент в списке, но позже мы добавим еще.
        // Список содержит клетки, которые может быть находятся вдоль пути, который вы выберете, а может и нет.
        // Проще говоря, это список клеток, которые нужно проверить.
        openSet.add(this.startCell);

        process(this.startCell);

        //Дальше мы выберем одну из соседних клеток в открытом списке и практически повторим вышеописанный процесс . Но какую клетку мы выберем? Ту, у которой меньше стоимость F.

        TreeCell finishCell = null;

        Logger.logWithMark("First Cycle");
        while (true) {
            TreeCell treeCell = openSet.peek(); // ожидаем, что здесь Минимальный F

            // если Null значит возможно target и есть NPC
            if (treeCell == null) {
                break;
            }

            if (treeCell.getCoo().equals(targetCoo)) {
                finishCell = treeCell;
                break;
            }

            process(treeCell);
        }
        Logger.logWithMark("First Cycle");

        List<Coo> results = new ArrayList();
        // if we can not find path to target cell
        if (finishCell != null) {
            TreeCell currentTreeCell = finishCell;
            while (true) {
                results.add(currentTreeCell.getCoo());
                currentTreeCell = currentTreeCell.getParent();
                if (currentTreeCell == null) {
                    break;
                }
            }
        }

        this.searchingInProgress = false;
        return results;
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

        if (containsCoo(targetCell.getCoo(), Lists.newArrayList(cooTop, cooRight, cooBottom, cooLeft))) {
            if (WorldObjectType.canCommunicate(LayerUtil.getCell(layer, targetCell.getCoo()))) {
                TreeCell target = new TreeCell(targetCell.getCoo(), targetCell.getCoo(), parent);
                if (!openSet.contains(target)) {
                    openSet.add(target);
                }
            }
        }

        if (cooTop != null && WorldObjectType.isTransit(layer, cooTop)) {
            TreeCell top = new TreeCell(cooTop, targetCell.getCoo(), parent);
            if (!closeSet.contains(top) && !openSet.contains(top)) {
                openSet.add(top);
            }
        }
        if (cooRight != null && WorldObjectType.isTransit(layer, cooRight)) {
            TreeCell right = new TreeCell(cooRight, targetCell.getCoo(), parent);
            if (!closeSet.contains(right) && !openSet.contains(right)) {
                openSet.add(right);
            }
        }
        if (cooBottom != null && WorldObjectType.isTransit(layer, cooBottom)) {
            TreeCell bottom = new TreeCell(cooBottom, targetCell.getCoo(), parent);
            if (!closeSet.contains(bottom) && !openSet.contains(bottom)) {
                openSet.add(bottom);
            }
        }
        if (cooLeft != null && WorldObjectType.isTransit(layer, cooLeft)) {
            TreeCell left = new TreeCell(cooLeft, targetCell.getCoo(), parent);
            if (!closeSet.contains(left) && !openSet.contains(left)) {
                openSet.add(left);
            }
        }
    }

    private boolean containsCoo(Coo target, List<Coo> array) {
        return target != null && array.contains(target);
    }

    public boolean isSearchingInProgress() {
        return searchingInProgress;
    }
}