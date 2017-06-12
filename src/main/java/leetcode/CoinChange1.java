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
public class CoinChange1 {

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

        CoinChange1 c = new CoinChange1();
        int[] coins = new int[]{1};
        int count = c.change(1, coins);
        System.out.print(count);
    }
}
