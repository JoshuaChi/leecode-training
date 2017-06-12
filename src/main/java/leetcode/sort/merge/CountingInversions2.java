package leetcode.sort.merge;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Joshua on 6/12/17.
 */
public class CountingInversions2 {
    public static long countInversions(int[] arr){
        int[] counter = new int[1];
        merge(arr, 0, arr.length, counter);
        return counter[0];
    }

    public static void merge(int[] arr, int start, int end, int[] counter) {
        if (start+1 >= end) {
            return;
        }


        int mid = start + (end-start)/2;
        int[] leftArray = Arrays.copyOfRange(arr, start, mid);
        merge(leftArray, 0, leftArray.length, counter);
        int[] rightArray = Arrays.copyOfRange(arr, mid, end);
        merge(rightArray, 0, rightArray.length, counter);

        int leftCursor = 0;
        int rightCursor = 0;
        int[] newArray = new int[end-start];
        int count = 0;
        while(leftCursor < leftArray.length && rightCursor < rightArray.length) {
            if (leftArray[leftCursor] == rightArray[rightCursor]) {
                newArray[count] = leftArray[leftCursor];
                newArray[count] = rightArray[rightCursor];
                leftCursor++;
                rightCursor++;

            }
            else if (leftArray[leftCursor] < rightArray[rightCursor]) {
                newArray[count] = leftArray[leftCursor];
                leftCursor++;
            }
            else {
                newArray[count] = rightArray[rightCursor];
                rightCursor++;
                counter[0]++;
            }
            count++;
        }

        while(leftCursor < leftArray.length) {
            newArray[count] = leftArray[leftCursor];
            leftCursor++;
            count++;
        }

        while(rightCursor < rightArray.length) {
            newArray[count] = rightArray[rightCursor];
            rightCursor++;
            count++;
        }

        System.arraycopy(newArray, 0, arr, start, end-start);
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
