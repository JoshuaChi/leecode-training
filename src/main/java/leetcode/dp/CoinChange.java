package leetcode.dp;

import java.util.*;

/**
 * Created by Joshua on 5/19/17.
 */
public class CoinChange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for (int coins_i = 0; coins_i < m; coins_i++) {
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
    public static long makeChange(int[] coins, int money) {
        int lastCoin = coins[coins.length-1];
        int[][] DP = new int[money+1][lastCoin+1];
        DP[0][0] = 1;
        for (int i=1; i<DP.length; i++) {
            DP[i][0] = 0;
        }
        for (int i=0; i<DP[0].length; i++) {
            DP[0][i] = 1;
        }

        for (int i=1; i<DP.length; i++) { //money
            for (int j=1; j<DP[0].length; j++) { //coins
                if (i-j<0) {
                    DP[i][j] = DP[i][j-1];
                }
                else {
                    if (exists(coins, j) == false) {
                        DP[i][j] = DP[i][j-1];
                    }
                    else {
                        DP[i][j] = DP[i][j-1] + DP[i-j][j];
                    }

                }
                //System.out.println("DP["+i+"]["+j+"]" + DP[i][j]);
            }
        }
        //System.out.println(lastCoin + "-" + DP[0].length);
        //System.out.println(money + " - " + DP.length);
        return (long)DP[money][lastCoin];
    }
    public static boolean exists(int[] coins, int coin) {
        for (int i=0; i<coins.length; i++) {
            if (coin == coins[i]) {
                return true;
            }
        }
        return false;

    }
}
