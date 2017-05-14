package leetcode.pattern.builder.meal;

import leetcode.pattern.builder.item.burger.ChickenBurger;
import leetcode.pattern.builder.item.drink.Pepsi;
import leetcode.pattern.builder.packing.Bottle;
import leetcode.pattern.builder.packing.Wrapper;

/**
 * Created by Joshua on 5/14/17.
 */
public class NonVegMeal extends Meal {
    public NonVegMeal() {

        ChickenBurger item = new ChickenBurger();
        item.packingWith(new Wrapper());
        this.addItem(item);

        Pepsi pepsi = new Pepsi();
        pepsi.packingWith(new Bottle());
        this.addItem(pepsi);
    }
}
