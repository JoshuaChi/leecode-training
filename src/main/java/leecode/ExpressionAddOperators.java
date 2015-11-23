package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joshua on 10/7/15.
 */
public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {

        return null;
    }

    /**
     * factors: 105 can be 1, 0, 5 or 10, 5
     *
     * @param target
     * @param factors
     * @return int
     */

    public int decompose(int target, List<Integer> factors) {
        return 0;
    }

    /**
     * By giving "1054", return "1,0,5,4", "10,5,4", "105,4", "1054"
     * @param factor
     * @return List<Integer>
     */
    private ArrayList<ArrayList<Integer>> composeFactor(String factor) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int i = 0;
        int inter = 1;
        while (inter < factor.length()) {
            while(i < factor.length()-1) {
                factor.substring(i, i+1);

            }
            inter++;
        }

        return result;

    }

    /**
     * Give a numerator, try +|-|* with provide denominator
     *
     * @param target
     * @param denominator
     * @return String - possible solution, e.g. ("-2" or "*4")
     */
    public String compose(int target, int denominator) {


        return "";
    }

    /**
     * Given target, by trying three operators with $number
     *
     * @param target
     * @param number
     * @return
     */
    private boolean isPossible(int target, int number) {
        return false;
    }
}
