package leetcode;

/**
 * Created by Joshua on 6/8/17.
 *
 You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1.

 @LeetCode 322
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];

        dp[0][0] = 1;

        for (int i=1; i<=coins.length; i++) {
            dp[i][0] = 0;
            for (int j=1; j<=amount; j++) {
                if(i==1) {
                    dp[1][j] = 1;
                }
                else {
                    //dp[i-1][j] - the previous i-1 items, compose j amount how many solutions //without considering ith item;
                    //dp[i][j-coins[i]] //consider ith item

                    dp[i][j] = dp[i-1][j] + ( (j < coins[i-1])?0:dp[i][j-coins[i-1]] );
                }
            }
        }
        return dp[coins.length][amount];
    }


    public static void main(String[] args) {

        CoinChange2 c = new CoinChange2();
        int[] coins = new int[]{1,2,5};
        int count = c.change(5, coins);
        System.out.print(count);
    }
}
