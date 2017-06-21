package leetcode.sort;

/**
 * Created by Joshua on 6/17/17.
 */
public class MergeSort2 {
    private static void swap(int[] ary, int left, int right) {
        int tmp = ary[left];
        ary[left] = ary[right];
        ary[right] = tmp;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3, 0, 1, 8, 7, 2, 5, 4, 9, 6};
        sort(nums, 0, nums.length);
        System.out.println(" ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }

    //[0,1,2,3,4] start=0, end=5
    private static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end-start)/2; //mid=2

        sort(nums, start, mid); //[0,1] -> [0,0],[0,1]
        sort(nums, mid+1, end);

        int index1 = start;
        int index2 = mid;

        int cursor = 0;
        int[] newSubNums = new int[end-start];

        while (cursor < newSubNums.length) {
            if (index1 < mid && index2 < end) {
                if (nums[index1] > nums[index2]) {
                    newSubNums[cursor] = nums[index2];
                    index2++;
                } else {
                    newSubNums[cursor] = nums[index1];
                    index1++;
                }
            }
            else if (index1 < mid) {
                newSubNums[cursor] = nums[index1];
                index1++;
            }
            else if (index2 < end) {
                newSubNums[cursor] = nums[index2];
                index2++;
            }
            cursor++;
        }
        System.arraycopy(newSubNums, 0, nums, start, end-start);

    }
}
