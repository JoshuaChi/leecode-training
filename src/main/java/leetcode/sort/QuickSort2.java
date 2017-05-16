package leetcode.sort;

/**
 * Created by Joshua on 5/16/17.
 */

/**
 * https://www.youtube.com/watch?v=ywWBy6J5gz8
 */
public class QuickSort2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newAry = combine(nums1, nums2);
        for (int i=0; i< newAry.length; i++) {
            //System.out.print(newAry[i]+" ");
        }
        quickSort(newAry, 0, newAry.length-1);
        for (int i=0; i< newAry.length; i++) {
            //System.out.print(newAry[i]+" ");
        }
        if (newAry.length % 2 == 0) {
            return (Double.valueOf(newAry[newAry.length/2]) + Double.valueOf(newAry[newAry.length/2-1]) )/2;
        }
        else {
            return Double.valueOf(newAry[newAry.length/2]);
        }
    }

    public int[] combine(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        for (int i=0; i< nums1.length; i++) {
            result[i] = nums1[i];
        }
        for (int i=0; i< nums2.length; i++) {
            result[nums1.length+i] = nums2[i];
        }

        return result;

    }

    public void sortArrayAsc(int[] nums) {
        boolean hasSwap = false;
        for (int i=0; i< nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                    hasSwap = true;
                }
            }
        }
    }

    /**
     * Assume the pointer is on the left and compare is onthe right
     *
     */
    public void quickSort(int[] nums, int pointer, int compare) {
        int left = pointer;
        int right = compare;
        if (pointer >= compare) {
            return;
        }
        while(true) {
            //pointer is on the left of compare
            while((pointer <= compare) && (nums[compare] >= nums[pointer])) {
                compare--;
            }
            if (pointer < compare) {
                //System.out.println("[1]. pointer: "+pointer+"; compare:"+compare+"<>"+nums[pointer]+" || "+nums[compare]);
                swap(nums, pointer, compare);
                int t = pointer;
                pointer = compare;
                compare = t;
            }
            else {
                break;
            }

            //pointer is on the right of compare
            while( (pointer >= compare) && (nums[compare] <= nums[pointer])) {
                compare++;
            }
            if (pointer > compare) {
                //System.out.println("[2]. pointer: "+pointer+"; compare:"+compare+"\n if "+nums[pointer]+" >"+nums[compare]);
                swap(nums, pointer, compare);
                int t = pointer;
                pointer = compare;
                compare = t;
            }
            else{
                break;
            }
        }
        if (pointer>=0 && pointer<nums.length ) {
            //System.out.println("[3]. pointer: "+pointer);
            quickSort(nums, left, pointer-1);
            //System.out.println("[4]. left: "+left+"; pointer-1:"+(pointer-1));
            quickSort(nums, pointer+1, right);
            //System.out.println("[5]. (pointer+1): "+(pointer+1)+"; right:"+right);
        }

    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}