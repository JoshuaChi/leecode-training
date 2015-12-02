package leetcode;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joshua on 10/7/15.
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        ArrayList<ArrayList<Long>> factorArray = composeFactor(num);
        ArrayList<String> result = new ArrayList<String>();
        for (ArrayList<Long> group : factorArray) {
            try {
                compose(target, group, result);
            }catch (Exception e){
                //TODO
            }
        }
        System.out.println(result.toString());
        return result;
    }

    /**
     * Give a target(e.g. 6), try +|-|* with provide denominator(e.g. 123)
     *
     * @param target      e.g. 6
     * @param denominator e.g. 1,2,3
     * @return String - 1+2+3 or 1*2*3
     */
    public void compose(int target, ArrayList<Long> denominator, ArrayList<String> r) throws Exception {
        ArrayList<String> result = new ArrayList<String>();

        //e.g. 1
        long resultFromLastCalculation = denominator.remove(0);

        //e.g. "1"
        String stringResult = String.valueOf(resultFromLastCalculation);

        evalCalculate(target, stringResult, denominator, 0, r);

    }

    public void evalCalculate(int target, String result, ArrayList<Long>
            denominator, int index, ArrayList<String> r) throws Exception {
        int size = denominator.size();
        if (index + 1 > size) {
            if (eval(result) == target) {
                System.out.println(result);
                r.add(result);
            }

            return;
        }

        long number = denominator.get(index);

//        System.out.println("     -    " + size + " - " + result + "-" + number);
        evalCalculate(target, result + "-" + number,
                denominator, index + 1, r);

//        System.out.println("     +    " + size + " - " + result + "+" + number);
        evalCalculate(target, result + "+" + number,
                denominator, index + 1, r);

//        System.out.println("     *    " + size + " - " + result + "*" + number);
        evalCalculate(target, result + "*" + number,
                denominator, index + 1, r);
    }

    private Integer eval(String expression) throws Exception {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");

        int result = 0;
        try {
            result = (Integer) engine.eval(expression);
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            return result;
        }
    }

    /**
     * By giving "1054", return "1,0,5,4", "10,5,4", "105,4", "1054"
     *
     * @param factor
     * @return List<Integer>
     */
    public ArrayList<ArrayList<Long>> composeFactor(String factor) {
        ArrayList<ArrayList<Long>> result = new ArrayList<ArrayList<Long>>();
        int j = 1;
        while (j <= factor.length()) {
            ArrayList<Long> temp = new ArrayList<Long>();

            //get first sub string
            temp.add(Long.valueOf(factor.substring(0, j)));

            int i = 0;
            //set loop step 1
            while (j + i < factor.length()) {
                temp.add(Long.valueOf(factor.substring(i + j, i + j + 1)));
                i++;
            }
            result.add(temp);
            j++;
        }

        return result;

    }
}
