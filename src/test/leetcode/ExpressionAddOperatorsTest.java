package leetcode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by joshua.chi on 11/24/15.
 */
public class ExpressionAddOperatorsTest {
    @Test
    public void testComposeFactor() throws Exception {
        ExpressionAddOperators ex = new ExpressionAddOperators();
        ArrayList<ArrayList<Long>> result = ex.composeFactor("3456237490");
        for(ArrayList<Long> i: result) {
            for(Long j: i) {
                System.out.println(i+"-"+j);
            }
        }
    }

    @Test
    public void testAddOperators () {
        ExpressionAddOperators ex = new ExpressionAddOperators();
//        ex.addOperators("232", 8);
//        ex.addOperators("105", 5);
//        ex.addOperators("00", 0);
        ex.addOperators("3456237490", 9191);
    }

}