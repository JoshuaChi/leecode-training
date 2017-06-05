package leetcode.sort;

/**
 * Created by joshua.chi on 6/2/17.
 */
public class QuickSort3 {
    public static void sort(int[] items, int start, int end) {
        int pivot = end;
        int index = start;
        if (start >= pivot) {
            return;
        }

        while (index != pivot) {

            if (index < pivot && items[index] > items[pivot]) {
                swap(items, index, pivot);
            }
            else if (index > pivot && items[index] < items[pivot]) {
                swap(items, index, pivot);
            }

            if (index < pivot) {
                int tmp = index;
                index = pivot;
                pivot = tmp;
                index--;
            }
            else if(index > pivot) {
                int tmp = index;
                index = pivot;
                pivot = tmp;
                index++;
            }

        }
        sort(items, start, pivot);
        sort(items, pivot+1, end);

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
