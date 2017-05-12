package leetcode;

/**
 * Created by Joshua.Chi <joshua.chi@akqa.com>
 *
 * @author joshua.chi
 * @date 5/11/17
 */
public class Fibonacci {
    int max = 4000000;

    public int sum(int[] nums) {
        int r = 0;
        for(int i=0; i< nums.length; i++) {
            r += nums[i];
        }
        return r;
    }

    public int cal(int[] nums, int result) {
        int next = sum(nums);

        if (isEven(next)) {
            result += next;
        }

        if (next > max) {
            System.out.println(next);
            return result;
        }
        nums = add(nums, next);
        return cal(nums, result);
    }

    private int[] add(int[] nums, int next) {
        int[] newNums = new int[nums.length+1];
        for (int i=0; i< nums.length; i++) {
            newNums[i] = nums[i];
        }
        newNums[nums.length] = next;
        return newNums;
    }

    private boolean isEven(int num) {
        if (num % 2 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Fibonacci f = new Fibonacci();
        int[] start = new int[] {1, 2};
        System.out.print(f.cal(start, 0));
    }
}
