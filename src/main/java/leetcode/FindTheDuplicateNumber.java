package leetcode;

/**
 * Created by Joshua on 10/3/15.
 *
 * 53 / 53 test cases passed.
 * Status: Accepted
 * Runtime: 5 ms
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int result = -1;
        quickSort(nums, 0, 0, nums.length-1);
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                result = nums[i];
            }
        }
        return result;
    }



    public void quickSort(int[] nums, int k, int low, int high) {
        int i = low;
        int j = high;
        if (i != j) {
            while (i < j) {
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
            quickSort(nums, low, low, k - 1 > low ? k - 1 : low);
            quickSort(nums, k + 1 < high ? k + 1 : high, k + 1 < high ? k + 1 : high, high);
        }
    }

    private void switchPosition(int[] nums, int j, int k) {
        int tmp = nums[j];
        nums[j] = nums[k];
        nums[k] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {
            5,4,7,5,3,2
        };

        FindTheDuplicateNumber m = new FindTheDuplicateNumber();
        int result = m.findDuplicate(nums);
        System.out.println(result);


    }
}
