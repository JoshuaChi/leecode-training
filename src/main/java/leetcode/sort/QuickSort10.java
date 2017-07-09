package leetcode.sort;

/**
 * Created by Joshua on 6/17/17.
 */
public class QuickSort10 {

    private static void swap(int[] ary, int left, int right) {
        int tmp = ary[left];
        ary[left] = ary[right];
        ary[right] = tmp;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3, 0, 1, 8, 7, 2, 5, 4, 9, 6};
        sort(nums, 0, nums.length - 1);
        System.out.println(" ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }

    public static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start;
        int pivot = end;
        while(left != pivot) {
            if (left < pivot && nums[left] > nums[pivot]) {
                swap(nums, left, pivot);
                int t = left;
                left = pivot;
                pivot = t;
            }

            if (left > pivot && nums[left] < nums[pivot]) {
                swap(nums, left, pivot);
                int t = left;
                left = pivot;
                pivot = t;
            }
            if (left < pivot && nums[left] <= nums[pivot]) {
                left++;
            }
            if (left > pivot && nums[left] >= nums[pivot]) {
                left--;
            }
        }
        sort(nums, start, pivot-1);
        sort(nums, start+1, end);
    }
}
