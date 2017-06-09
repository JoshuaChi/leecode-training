package leetcode;

/**
 * Created by Joshua on 6/8/17.
 *
 Input: amount = 5, coins = [1, 2, 5]
 Output: 4
 Explanation: there are four ways to make up the amount:
 5=5
 5=2+2+1
 5=2+1+1+1
 5=1+1+1+1+1
 */
public class CoinChange {
    int[] dp;
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];

        dp[0] = 1;
        if (0 == amount) {
            return 1;
        }

        if (coins.length < 1) {
            return 0;
        }

        for (int j=1; j<=amount; j++) {
            for (int i=0; i<coins.length ; i++) {
                if (coins[i] <= j) {
                    dp[j] = dp[j] + dp[j-coins[i]];
                }
            }
        }
        return dp[amount];
    }



    public static void main(String[] args) {

        CoinChange c = new CoinChange();
        int[] coins = new int[]{1,2,5};
        int count = c.change(4, coins);
        System.out.print(count);
    }
}
