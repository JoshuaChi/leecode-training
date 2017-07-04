package leetcode.dp;

import java.util.Arrays;

/**
 * Created by Joshua on 7/4/17.
 */
public class GoldMine {
    /**
     * 总共10个人，有A（2），B（3），C（5）三个金矿
     * 如果先去挖A，那么剩下8个人能够得到的最大金子数就是10个人能得到的最大金字数
     * 变为求 max(dp[2][10-3], dp[3][10-5]) + mine[1];
     * @param gold
     * @param need
     * @param peoples
     */
    public int dp(int[] gold, int[] need, int peoples) {
        int[][] dp = new int[gold.length+1][peoples+1];
        for (int i=0; i<dp.length; i++) {
            Arrays.fill(dp[i], 0);
        }

        for (int i=1; i<=gold.length; i++) {
            dp[i][1] = 0;
        }

        int max = 0;
        for (int i=0; i<gold.length; i++) {
            int value = gold[i];

            for (int j=0; j<peoples; j++) {
                if (j+1 >= need[i]) {
                    dp[i+1][j+1] = Math.max(max, value+dp[i][j+1-need[i]]);
                }
            }
        }
        return dp[gold.length][peoples];

    }

    public static void main(String[] args) {
        GoldMine goldMine = new GoldMine();
        int[] gold = new int[]{30, 50, 100};
        int[] need = new int[]{3, 2, 3};
        int value = goldMine.dp(gold, need, 5);

        System.out.println(value);
    }
}
