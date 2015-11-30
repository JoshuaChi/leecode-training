package leetcode;

import java.util.*;

/**
 * Created by Joshua on 10/7/15.
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        ArrayList<ArrayList<Integer>> factorArray = composeFactor(num);
        for (ArrayList<Integer> group : factorArray) {
            compose(target, group);
        }
        return null;
    }

    /**
     * Give a target(e.g. 6), try +|-|* with provide denominator(e.g. 123)
     *
     * @param target e.g. 6
     * @param denominator e.g. 1,2,3
     * @return String - 1+2+3 or 1*2*3
     */
    public void compose(int target, ArrayList<Integer> denominator) {
        ArrayList<String> result = new ArrayList<String>();

        //e.g. 1
        int resultFromLastCalculation = denominator.remove(0);

        //e.g. "1"
        String stringResult = String.valueOf(resultFromLastCalculation);

        HashMap<Integer, String> collection = new HashMap<Integer, String>();
        int i = 0;
//        while (denominator.size() > i+1) {
            //e.g.
            calculate(target, resultFromLastCalculation, stringResult, denominator, i);
//        }

        Iterator<Map.Entry<Integer, String>> it = collection.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> pair = it.next();
            if (pair.getKey() == target) {
                result.add(pair.getValue());
            }
        }

//        System.out.println(result.toString());
    }

    /**
     * If the denominator.length - 1 > 0, continue calculate in this function.
     *
     * @param resultFromLastCalculation
     * @param result
     */
    public void calculate(int target, int resultFromLastCalculation, String result, ArrayList<Integer>
            denominator, int index) {
        int size = denominator.size();
        if (index+1 > size) {
            if (resultFromLastCalculation == target) {
                System.out.println(result);
            }

            return;
        }

        int number = denominator.get(index);

//        System.out.println("     -    " + size +" - " + result + "-" + number);
        calculate(target, resultFromLastCalculation - number, result + "-" + number,
                denominator, index+1);

//        System.out.println("     +    " + size +" - " + result + "+" + number);
        calculate(target, resultFromLastCalculation + number, result + "+" + number,
                denominator, index+1);

//        System.out.println("     *    " + size +" - " + result + "*" + number);
        calculate(target, resultFromLastCalculation * number, result + "*" + number,
                denominator, index+1);
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
