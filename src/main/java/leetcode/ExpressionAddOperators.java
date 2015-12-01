package leetcode;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joshua on 10/7/15.
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) throws ScriptException {
        ArrayList<ArrayList<Integer>> factorArray = composeFactor(num);
        for (ArrayList<Integer> group : factorArray) {
            compose(target, group);
        }
        return null;
    }

    /**
     * Give a target(e.g. 6), try +|-|* with provide denominator(e.g. 123)
     *
     * @param target      e.g. 6
     * @param denominator e.g. 1,2,3
     * @return String - 1+2+3 or 1*2*3
     */
    public void compose(int target, ArrayList<Integer> denominator) throws ScriptException {
        ArrayList<String> result = new ArrayList<String>();

        //e.g. 1
        int resultFromLastCalculation = denominator.remove(0);

        //e.g. "1"
        String stringResult = String.valueOf(resultFromLastCalculation);

        evalCalculate(target, stringResult, denominator, 0);

    }

    public void evalCalculate(int target, String result, ArrayList<Integer>
            denominator, int index) throws ScriptException {
        int size = denominator.size();
        if (index + 1 > size) {
            if (eval(result) == target) {
                System.out.println(result);
            }

            return;
        }

        int number = denominator.get(index);

//        System.out.println("     -    " + size + " - " + result + "-" + number);
        evalCalculate(target, result + "-" + number,
                denominator, index + 1);

//        System.out.println("     +    " + size + " - " + result + "+" + number);
        evalCalculate(target, result + "+" + number,
                denominator, index + 1);

//        System.out.println("     *    " + size + " - " + result + "*" + number);
        evalCalculate(target, result + "*" + number,
                denominator, index + 1);
    }

    private Integer eval(String expression) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        return (Integer) engine.eval(expression);

    }

    /**
     * By giving "1054", return "1,0,5,4", "10,5,4", "105,4", "1054"
     *
     * @param factor
     * @return List<Integer>
     */
    public ArrayList<ArrayList<Integer>> composeFactor(String factor) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int j = 1;
        while (j <= factor.length()) {
            ArrayList<Integer> temp = new ArrayList<Integer>();

            //get first sub string
            temp.add(Integer.valueOf(factor.substring(0, j)));

            int i = 0;
            //set loop step 1
            while (j + i < factor.length()) {
                temp.add(Integer.valueOf(factor.substring(i + j, i + j + 1)));
                i++;
            }
            result.add(temp);
            j++;
        }

        return result;

    }
}
