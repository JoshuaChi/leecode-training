package leetcode;

import java.util.Arrays;

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
        int[] cache = new int[amount+1];
        Arrays.fill(cache, -1);
        return dp(coins, amount, cache);
    }

    public int dp(int[] coins, int amount, int[] cache) {
        if (-1 != cache[amount]) {
            return cache[amount];
        }

        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            cache[0] = 0;
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int i=coins.length-1; i>=0; i--) {
            if (coins[i] > amount) {
                continue;
            }
            int count = dp(coins, amount-coins[i], cache);
            if (count != Integer.MAX_VALUE && count >=0 && (count + 1) < min) {
                min = count + 1;
            }
        }
        cache[amount] = min;
        if (min != Integer.MAX_VALUE) {
            return min;
        }
        return -1;
    }


    public static void main(String[] args) {

        CoinChange3 c = new CoinChange3();
        int[] coins = new int[]{442,295,365,485};
        int count = c.coinChange(coins, 8091);
        System.out.print(count);
    }
}
