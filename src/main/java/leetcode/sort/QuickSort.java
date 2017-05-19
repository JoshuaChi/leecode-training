package leetcode.sort;

import java.util.*;

/**
 * Created by Joshua on 5/13/17.
 */
public class QuickSort {

    /**
     * $wall starts from element right side;
     *
     * @param nums
     * @param wall
     */
    private void quickSort(int[] nums, int wall) {
        int index = wall;
        int last = nums.length-1;
        if (wall >= last) {
            return;
        }

        while(true) {
            if (index <= last) {
                break;
            }

            if (nums[wall] > nums[last]) {
                swap(nums, wall, index);
                wall++;
                index++;
            }
            else {
                index++;
            }
        }
        swap(nums, wall, last);
        quickSort(nums, wall);
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

    }
}