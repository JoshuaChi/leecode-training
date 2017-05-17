package leetcode.sort;

/**
 * Created by Joshua on 5/17/17.
 */
import java.util.Scanner;

public class HeapSort2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            doit(a, a_i+1);
            System.out.println(String.format("%.1f", calculate(a, a_i+1)));
        }
    }

    public static Double calculate(int[] nums, int len) {
        Double mid = Double.valueOf(nums[(len-1)/2]);
        Double mid2 = Double.valueOf(nums[(len-1)/2 + 1]);
        if (len%2 == 0) {
            return (mid + mid2)/2;
        }
        else {
            return mid;
        }
    }

    public static void doit(int [] nums, int capality) {
        int length = capality;
        for (int i=0; i< length; i++) {
            heapSort(nums, length-i);

            swap(nums, 0, length-i-1);
        }

    }
    public static void heapSort(int[] nums, int length) {
        for (int i=0; i<length/2-1; i++) {
            topToDown(nums, i, length);
        }
        for (int j=length/2-1; j<length; j++ ) {
            downToTop(nums, j);
        }
    }


    public static void downToTop(int[] nums, int i) {
        int parent = (i-1)/2;
        if (parent < 0) {
            return;
        }
        if (nums[i] < nums[parent]) {
            swap(nums, i, parent);
        }
        if (parent > 0) {
            downToTop(nums, parent);
        }
    }

    //MinHeap
    /**
     * parent compare with left,
     *  if left < parent, swap
     *  if (right < min(left, parent)), swap
     * @param nums
     * @param i
     */
    public static void topToDown(int[] nums, int i, int length) {
        int left = 2*i+1;
        int right = 2*(i+1);

        if (left >= length && right >= length) {
            return;
        }

        if (left < length && nums[i] > nums[left]) {
            swap(nums, i, left);
        }
        if (right < length && nums[i] > nums[right]) {
            swap(nums, i, right);
        }
        topToDown(nums, left, length);
        topToDown(nums, right, length);
    }


    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
