package leetcode.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Joshua on 7/5/17.
 */
public class CoinChange2 {
    static long getWays(long n, long[] c){
        long[][] dp = new long[(int)n+1][c.length+1];
        dp[0][0] = 1L;
        for (int i=1; i<dp.length; i++) {
            Arrays.fill(dp[i], 0L);
        }

        for (int i=0; i<(int)n; i++) {
            dp[i][1] = 1L;
            for (int j=0; j<c.length; j++) {
                if ((long)i+1L >= c[j]) {
                    dp[i+1][j+1] = dp[i+1][j] + dp[i+1-(int)c[j]][j+1];
                }
                else {
                    dp[i+1][j+1] = dp[i+1][j];
                }
            }
        }
        return dp[(int)n][c.length];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }
}
