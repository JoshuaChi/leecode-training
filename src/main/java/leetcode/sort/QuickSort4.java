package leetcode.sort;

/**
 * Created by joshua.chi on 6/2/17.
 */
public class QuickSort4 {
    public static void sort(int[] items, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start)/2;
        int pivot = items[mid];
        int left = start;
        int right = end;

        while (left >=0 && right <= end && left < pivot && right> pivot) {

            while (left >=0 && left < pivot && items[left] < pivot) {
                left--;
            }
            while (right <= end && right > pivot && items[right] > pivot) {
                right++;
            }
            if (left>=0 && right<=end) {
                swap(items, left, right);
            }
        }
        sort(items, start, mid);
        sort(items, mid+1, end);
    }

    private static void swap(int[] items, int start, int pivot) {
        int tmp = items[start];
        items[start] = items[pivot];
        items[pivot] = tmp;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{3, 0, 1, 8, 7, 2, 5, 4, 9, 6};
        sort(nums, 0, nums.length - 1);
        System.out.println(" ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
