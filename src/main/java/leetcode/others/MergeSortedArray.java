package leetcode.others;

/**
 * Created by Joshua on 5/19/17.
 */
public class MergeSortedArray {

    public static void merge(int[] nums1, int index1, int[] nums2, int index2, int[] result, int index3) {

        if (nums1.length < 1 && nums2.length < 1) {
            return;
        }
        if (index1 >= nums1.length && index2 >= nums2.length) {
            return;
        }

        if (index1 >= nums1.length) {
            mergeLeft(nums2, index2, result, index3);
            return;
        }
        else if(index2 >= nums2.length) {
            mergeLeft(nums1, index1, result, index3);
            return;
        }

        if (nums1[index1] > nums2[index2]) {
            result[index3] = nums2[index2];
            merge(nums1, index1, nums2, index2+1, result, index3+1);
        }
        else {
            result[index3] = nums1[index1];
            merge(nums1, index1+1, nums2, index2, result, index3+1);
        }


    }

    private static void mergeLeft(int[] nums, int index, int[] result, int index2) {
        for (int i=index;i<nums.length; i++) {
            result[index2] = nums[i];
            index2++;
        }
    }

    public static void main(String[] args) {

        int[] nums1 = new int[]{2,6,7,9};
        int[] nums2 = new int[]{1,3,4,8};
        int[] result = new int[nums1.length + nums2.length];
        merge(nums1, 0, nums2, 0, result, 0);
        for (int i=0; i< result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
