package leetcode.sort.insert;

/**
 * Created by Joshua on 5/21/17.
 */

/**
 *
 将第一个数和第二个数排序，然后构成一个有序序列
 将第三个数插入进去，构成一个新的有序序列。
 对第四个数、第五个数……直到最后一个数，重复第二步。
 如何写写成代码：

 首先设定插入次数，即循环次数，for(int i=1;i<length;i++)，1个数的那次不用插入。
 设定插入数和得到已经排好序列的最后一个数的位数。insertNum和j=i-1。
 从最后一个数开始向前循环，如果插入数小于当前数，就将当前数向后移动一位。
 将当前数放置到空着的位置，即j+1。
 */
public class InsertSort {
    public static void sort(int[] nums) {
        //nums: [3,1,8,4,5,2] ASC!!!
        for (int rightStart=1; rightStart<nums.length; rightStart++) { //O(N)
            int current = nums[rightStart];
            int leftEnd = rightStart-1; //3
            //[1,8,...]  - i
            if (current < nums[leftEnd]) {
                while(leftEnd>=0 && current < nums[leftEnd]) { //O(N)
                    nums[leftEnd+1] = nums[leftEnd];
                    leftEnd--;
                }
                nums[leftEnd+1] = current;
            }
        }

    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,3,6,2,5,8};
        sort(nums);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
