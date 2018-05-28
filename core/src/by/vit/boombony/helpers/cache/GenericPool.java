package by.vit.boombony.helpers.cache;


import com.badlogic.gdx.Gdx;

import java.util.Collections;
import java.util.Stack;

public abstract class GenericPool<T> {
    private final Stack<T> availableItems = new Stack<T>();
    private int unRecycledCount;
    private final int growth;

    public GenericPool() {
        this(0);
    }

    public GenericPool(final int initialSize) {
        this(initialSize, 1);
    }

    public GenericPool(final int initialSize, final int growth) {
        if (growth < 0) {
            throw new IllegalArgumentException("growth must be at least 0!");
        }

        this.growth = growth;

        if (initialSize > 0) {
            this.batchAllocatePoolItems(initialSize);
        }
    }

    public synchronized void reset() {
        availableItems.clear();
    }

    public synchronized int getUnRecycledCount() {
        return this.unRecycledCount;
    }

    protected abstract T onAllocatePoolItem();

    /**
     * @param item every item passes this method just before it gets recycled.
     */
    protected void onHandleRecycleItem(final T item) {
    }

    protected T onHandleAllocatePoolItem() {
        return this.onAllocatePoolItem();
    }

    /**
     * @param item every item that was just obtained from the pool, passes this method.
     */
    protected void onHandleObtainItem(final T item) {
    }

    public synchronized void batchAllocatePoolItems(final int count) {
        final Stack<T> availableItems = this.availableItems;
        for (int i = count - 1; i >= 0; i--) {
            availableItems.push(this.onHandleAllocatePoolItem());
        }
    }

    public synchronized T obtainPoolItem() {
        final T item;

        if (this.availableItems.size() > 0) {
            item = this.availableItems.pop();
        } else {
            if (this.growth == 1) {
                item = this.onHandleAllocatePoolItem();
            } else {
                this.batchAllocatePoolItems(this.growth);
                item = this.availableItems.pop();
            }
        }
        this.onHandleObtainItem(item);

        this.unRecycledCount++;
        return item;
    }

    public synchronized void recyclePoolItem(final T item) {
        if (item == null) {
            throw new IllegalArgumentException("Cannot recycle null item!");
        }

        this.onHandleRecycleItem(item);
        this.availableItems.push(item);
        this.unRecycledCount--;

        if (this.unRecycledCount < 0) {
            Gdx.app.log("GenericPool", "More items recycled than obtained!");
        }
    }

    public synchronized void shufflePoolItems() {
        Collections.shuffle(this.availableItems);
    }
}
