package leetcode.sort;

/**
 * Created by Joshua on 6/3/17.
 */
public class QuickSort5 {

    public static void sort(int[] ary, int left, int right) {
        if (left >= right) {
            return;
        }

        int index = left;
        int pivot = right;
        while (index != pivot) {
            if (index >= left && index <= right) {
                if (pivot>=0 && index < pivot && ary[pivot] < ary[index]) {
                    swap(ary, index, pivot);
                    int t = index;
                    index = pivot;
                    pivot = t;
                }

                if (pivot>=0 && index > pivot && ary[pivot] > ary[index]) {
                    swap(ary, index, pivot);
                    int t = index;
                    index = pivot;
                    pivot = t;
                }

                if (index < pivot) {
                    index ++;
                }
                else {
                    index--;
                }
            }
        }

        pivot -= 1;
        sort(ary, left, pivot);
        sort(ary, pivot+1, right);


    }

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
}
