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
public class CoinChangeDp2 {
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }

        int[][] dp = new int[coins[coins.length-1]+1][amount+1];
        dp[0][0] = 1;
        for (int j=1; j<= amount; j++) {
            dp[0][j] = 1;
        }

        for (int i=1; i<=coins[coins.length-1]; i++) {
            dp[i][0] = 1;
            for (int j=1; j<= amount; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }

        return dp[amount][coins[coins.length-1]];

    }


    public static void main(String[] args) {

        CoinChangeDp2 c = new CoinChangeDp2();
        int[] coins = new int[]{1,2,5};
        int count = c.change(5, coins);
        System.out.print(count);
    }
}
