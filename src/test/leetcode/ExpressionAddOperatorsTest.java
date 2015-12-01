package leetcode;

import org.junit.Test;

import javax.script.ScriptException;
import java.util.ArrayList;

/**
 * Created by joshua.chi on 11/24/15.
 */
public class ExpressionAddOperatorsTest {
    @Test
    public void testComposeFactor() throws Exception {
        ExpressionAddOperators ex = new ExpressionAddOperators();
        ArrayList<ArrayList<Integer>> result = ex.composeFactor("3456237490");
        for(ArrayList<Integer> i: result) {
            for(Integer j: i) {
                System.out.println(i+"-"+j);
            }
        }
    }

    @Test
    public void testAddOperators () throws ScriptException {
        ExpressionAddOperators ex = new ExpressionAddOperators();
//        ex.addOperators("232", 8);
//        ex.addOperators("105", 5);
//        ex.addOperators("00", 0);
        ex.addOperators("3456237490", 9191);
    }

}