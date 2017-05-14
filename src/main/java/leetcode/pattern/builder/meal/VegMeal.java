package leetcode.pattern.builder.meal;

import leetcode.pattern.builder.item.burger.VegBurger;
import leetcode.pattern.builder.item.drink.Coke;
import leetcode.pattern.builder.packing.Bottle;
import leetcode.pattern.builder.packing.Wrapper;

/**
 * Created by Joshua on 5/14/17.
 */
public class VegMeal extends Meal {

    public VegMeal() {
        VegBurger item = new VegBurger();
        item.packingWith(new Wrapper());
        this.addItem(item);

        Coke coke = new Coke();
        coke.packingWith(new Bottle());
        this.addItem(coke);

    }



}
