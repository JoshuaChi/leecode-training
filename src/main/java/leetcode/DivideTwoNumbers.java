package leetcode;

/**
 * Created by joshua.chi on 6/8/17.
 */
public class DivideTwoNumbers {
    /**
     * Notes:
     *  1). use Math.abs
     *  2). transfer to int
     *  3). sum of sum ; count of count
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(long dividend, long divisor) {

        if(divisor == 0 ) {
            return -1;
        }
        long dividendAb = Math.abs(dividend);
        long divisorAb = Math.abs(divisor);

        long count = d(dividendAb, divisorAb);

        if ( (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ) {
            if (count > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
            else {
                return -1 * (int)count;
            }
        }
        else {
            if (count > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            else {
                return (int)count;
            }
        }

    }

    public long d (long dividend, long divisor) {
        if (divisor == 1) {
            return dividend;
        }

        if (dividend == 0) {
            return 0L;
        }

        if (divisor > dividend) {
            return 0L;
        }

        int count = 1;
        long dsor = divisor;
        while (dsor + dsor < dividend) {
            count += count;
            dsor += dsor;
        }

        return count + d(dividend - dsor, divisor);
    }

    public static void main(String[] args) {
        DivideTwoNumbers d = new DivideTwoNumbers();
        long c = d.divide(-2147483648, -1);
        System.out.println(c);
    }
}
