package leetcode.others;

/**
 * Created by Joshua on 5/19/17.
 */

/**
 * You and your friend are playing a game
 * There is an list of numbers, you pick up one from either
 * the front or the rare. Then your friend pick up one
 * Question: What the maxmium sum of numbers you can get.
 *
 *
 A B 的策略是一样的
 当还剩0个时 A(B)什么都取不了
 当还剩1个时 A(B)只能取那一个
 当还剩2个时 A(B)取两个的最大值
 当还剩3个时 A(B)取两边最大值 中间的还归A(B).
 当还剩4个时 A(B)取 max(取最左边+右边三个的和减去B(A)取右边三个的最大值，取最右边+左边三个的和减去B(A)取左边三个的最大值)
 以此类推用DP解

 */
public class DP1 {

/*    public static int getMaxSum(int[] nums, int i, int j) {
        if (nums.length == 0) {
            return 0;
        }
        else if(nums.length == 1) {
            return nums[0];
        }
        else {
            int sum = sum(nums, i, j+1);
            if (nums[i] > nums[j]) {
                int chooseLeft = nums[i] + getMaxFromLeftArray(nums, i+1, j);

            }

            int chooseLeft = nums[i] + sum - getMaxSum(nums, i + 1, j);
            int chooseRight = sum - getMaxSum(nums, i, j-1);
            return Math.max(nums[i] + );
        }

        return 0;
    }

    private static int sum(int[] nums, int i, int j) {
        int r = 0;
        for (int t=i; t<j; t++) {
            r += nums[t];
        }
        return r;
    }

    public static int getMaxFromLeftArray(int[] nums, int from, int to) {
        return 0;
    }

    public static void main(String[] args) {

    }*/
}
