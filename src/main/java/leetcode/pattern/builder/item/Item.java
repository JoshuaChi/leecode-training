package leetcode.pattern.builder.item;

import leetcode.pattern.builder.packing.Packing;

/**
 * Created by Joshua on 5/14/17.
 */
public abstract class Item {
    public abstract String name();
    public abstract float price();

    private Packing packing = null;
    public String packing() {
        return packing.name();
    }
    public void packingWith(Packing packing) {
        this.packing = packing;
    }
}
