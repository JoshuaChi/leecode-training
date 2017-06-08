package leetcode;

/**
 * Created by joshua.chi on 6/8/17.
 */
public class DivideTwoNumbers {
    /**
     * 10/3 = 3
     *  10 - 3 = 7
     *      7 - 3 = 4
     *          4 - 3 = 1
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {

        if (dividend < 0 &) {

        }
        if (divisor > dividend) {
            return 0;
        }

        Math.abs(dividend) - Mas
        return 1 + divide(dividend-divisor, divisor);

    }

    public static void main(String[] args) {
        DivideTwoNumbers d = new DivideTwoNumbers();
        int c = d.divide(10, 3);
        System.out.println(c);
    }
}
