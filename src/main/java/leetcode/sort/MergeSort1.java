package leetcode.sort;

/**
 * Created by Joshua on 6/17/17.
 */
public class MergeSort1 {
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

    //[0,1,2,3,4]
    private static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2; //2
        sort(nums, start, mid);//[0,1,2]
        sort(nums, mid + 1, end);//[3,4]

        int[] newNums = new int[end - start + 1]; //5

        int cursor = 0;
        int leftLength = mid - start + 1; //2-0+1=3
        int rightLength = end - mid; //4-2=2

        int lc = start; //0
        int rc = mid + 1; //3
        while (cursor <= end - start) {

            if (lc < mid + 1 && rc < end + 1) {
                if (nums[lc] >= nums[rc]) {
                    newNums[cursor] = nums[rc];
                    rc++;
                } else if (nums[lc] < nums[rc]) {
                    newNums[cursor] = nums[lc];
                    lc++;
                }
            } else if (rc >= end+1 && lc < mid + 1) {
                newNums[cursor] = nums[lc];
                lc++;
            } else if (lc >= mid + 1 && rc < end+1) {
                newNums[cursor] = nums[rc];
                rc++;
            }
            cursor++;
        }


        if (newNums.length > 0)

        {
            System.arraycopy(newNums, 0, nums, start, newNums.length);
        }

    }
}
