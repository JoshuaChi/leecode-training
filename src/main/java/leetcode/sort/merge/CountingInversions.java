package leetcode.sort.merge;

/**
 * Created by Joshua on 5/21/17.
 */

import java.util.Scanner;

public class CountingInversions {

    public static long countInversions(int[] arr){

        long[] counter = new long[]{0L};
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length-1, counter);
        //System.out.println(counter[0]);
        return counter[0];
    }

    public static void mergeSort(int[] arr, int[] tmp, int leftStart, int rightEnd, long[] counter) {
        if (leftStart >= rightEnd) {
            return;
        }
        int leftEnd = leftStart + (rightEnd-leftStart)/2;
        mergeSort(arr, tmp, leftStart, leftEnd, counter);
        mergeSort(arr, tmp, leftEnd+1, rightEnd, counter);
        merge(arr, tmp, leftStart, rightEnd, counter);
    }

    public static void merge(int[] arr, int[] tmp, int leftStart, int rightEnd, long[] counter) {
        if (leftStart >= rightEnd) {
            return;
        }

        final int leftEnd = leftStart + (rightEnd-leftStart)/2;

        int[] result = new int[rightEnd-leftStart+1];
        int count=0;
        int rightStart = leftEnd+1;
        int left = leftStart;
        int right = rightStart;
        //L: [1,3,6,8]; R: [4,9,12,14,15];
        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                result[count] = arr[left];
                left++;
            }else {
                result[count] = arr[right];
                counter[0] += (leftEnd-left+1);
                right++;
            }
            count++;
        }

        //L: [1, 2, 3], R: [1, 2]
        if (left <= leftEnd) {
            //While copy last entry from left, we
            System.arraycopy(arr, left, result, count, leftEnd-left+1);
        }

        if (right <= rightEnd) {
            System.arraycopy(arr, right, result, count, rightEnd-right+1);
        }

        System.arraycopy(result, 0, arr, leftStart, result.length);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(countInversions(arr));
        }
    }


}
