package leetcode;

/**
 * Created by Joshua on 6/8/17.
 * LC:322
 You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1.

 Note:
 You may assume that you have an infinite number of each kind of coin.
 */
public class CoinChange3 {
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    public int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i=coins.length-1; i>=0; i--) {
            if (coins[i] > amount) {
                continue;
            }
            int count = dp(coins, amount-coins[i]);
            if (count >=0 && (count + 1) < min) {
                min = count + 1;
            }
        }
        return min == Integer.MAX_VALUE? -1: min;
    }



    public static void main(String[] args) {

        CoinChange3 c = new CoinChange3();
        int[] coins = new int[]{1,2,5};
        int count = c.coinChange(coins, 4);
        System.out.print(count);
    }
}
