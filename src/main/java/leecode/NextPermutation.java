package leecode;

import java.util.Arrays;

/**
 * Created by Joshua on 10/1/15.
 * https://leetcode.com/problems/next-permutation/
 *
 * 265 / 265 test cases passed.
 * Status: Accepted
 * Runtime: 17 ms
 *
 * The main idea behind code is :
 *  step1: find the two numbers(nums[j-1], nums[j]) which are in ascending order from tail to header:
 *  step2: find the bigger number "k" in (nums[j], nums[length-1]), switch (nums[j-1], nums[k])
 *  step3: quick sort (nums[j], nums[length-1])
 *
 */
public class NextPermutation {
    /**
     * 1. check last two numbers firstly, if desc, switch;
     * 2. otherwise, find smallest number and switch to 1st posiiton,
     * re-ordering left nunmbers in asc
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        System.out.println(Arrays.toString(nums));
        String ori = Arrays.toString(nums);
        _nextPermutation(nums);
        if (Arrays.toString(nums).equals(ori)) {
            quickSort(nums, 0, 0, nums.length-1);
        }

    }

    private void _nextPermutation(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return;
        }

        int k = -1;
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                k = i-1;
                break;
            }
        }

        //the nums are in desc order
        if (k == -1) {
            return;
        }

        int targetIndex = lookup(nums, k);
        if (targetIndex == -1) {
            return;
        }
        int tmp = nums[targetIndex];
        nums[targetIndex] = nums[k];
        nums[k] = tmp;

        quickSort(nums, k+1, k+1, length - 1);
    }

    /**
     * @param nums
     * @return -1:not found; otherwise return index in nums
     */
    private int lookup(int[] nums, int k) {
        int target = nums[k];
        int tmp = -1;
        for (int i = 1; i < nums.length; i++) {
            if (tmp != -1 && nums[i]<nums[tmp] && nums[i] > target) {
                tmp = i;
            }
            else if (nums[i] > target) {
                tmp = i;
            }
        }
        return tmp;
    }


    public void quickSort(int[] nums, int k, int low, int high) {
        int i = low;
        int j = high;
        if (i!=j) {
            while (i< j) {
                while (i < j) {
                    if (nums[j] < nums[k]) {
                        switchPosition(nums, j, k);
                        k = j;
                        break;
                    }
                    j--;
                }


                while (i < j) {
                    if (nums[i] >= nums[k]) {
                        switchPosition(nums, i, k);
                        k = i;
                        break;
                    }
                    i++;
                }
            }
            quickSort(nums, low, low, k-1>low?k-1:low);
            quickSort(nums, k+1<high?k+1:high, k+1<high?k+1:high, high);
        }

    }

    private void switchPosition(int[] nums, int j, int k) {
        int tmp = nums[j];
        nums[j] = nums[k];
        nums[k] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {
                5,4,7,5,3,2 //[5,5,2,3,4,7]
//                1,3,2,
//                1, 1
        };

        NextPermutation n = new NextPermutation();
        n.nextPermutation(nums);
        System.out.println("nums:"+Arrays.toString(nums)+"!!");

    }
}