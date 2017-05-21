package leetcode.sort.shell;

/**
 * Created by Joshua on 5/21/17.
 */
public class ShellSort {

    public static void sort(int[] nums, int span) {
        int d = nums.length/span;
        if (span-1 >=0 && (nums.length/(span-1) == d)) {
            return;
        }

        while (d >= 1) {
            for (int i=0; i<d; i++) {
                insertSort(nums, d, i);
            }
            span++;
            d = nums.length/span;
        }
    }

    public static void insertSort(int[] nums, int span, int start) {
        for (int leftWall = start; leftWall < nums.length-1; leftWall+=span) {
            int rightStart = leftWall + span;
            if (rightStart<nums.length && nums[leftWall] > nums[rightStart]) {
                int current = nums[rightStart];
                //[3], [1,4,5,2]
                int left = leftWall;
                while(left >=0 && nums[left] > current) {
                    nums[left+span] = nums[left];
                    left -= span;
                }
                nums[left+span] = current;
            }
        }
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        int[] nums = new int[]{1, 3, 6, 2, 5, 8};
        insertSort(nums, 1, 0);
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println(" ");
        startTime = System.currentTimeMillis();
        nums = new int[]{1, 3, 6, 2, 5, 8};
        sort(nums, 2);
        endTime   = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println(totalTime);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
