package leetcode.pattern.builder;

import leetcode.pattern.builder.meal.Meal;
import leetcode.pattern.builder.meal.NonVegMeal;
import leetcode.pattern.builder.meal.VegMeal;

/**
 * Created by Joshua on 5/14/17.
 */
public class MealBuilder {
    public Meal prepareVegMeal() {
        VegMeal meal = new VegMeal();
        return meal;

    }

    public Meal prepareNonVegMeal() {
        NonVegMeal meal = new NonVegMeal();
        return meal;
    }
}
