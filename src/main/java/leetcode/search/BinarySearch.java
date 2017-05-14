package leetcode.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Joshua on 5/14/17.
 */

/**
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor
 */
public class BinarySearch {

    public static int binarySearch(int first, int last, IceCream[] arr, int search) {
        if (first > last) {
            return -1;
        }
        int mid = first + (last-first)/2;
        IceCream iceCream = arr[mid];
        if (iceCream.flavor == search) {
            return iceCream.index;
        }
        if (search > iceCream.flavor) {
            return binarySearch(mid+1, last, arr, search);
        }
        else {
            return binarySearch(first, mid-1, arr, search);
        }
    }

    public static void main(String[] args) {

        int t;
        int n, m;

        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        for(int test = 0; test < t; test++) {

            m = in.nextInt();
            n = in.nextInt();
            IceCream[] arr = new IceCream[n];

            for (int i = 0; i < n; i++)
                arr[i] = new IceCream(in.nextInt(), i + 1);

            Arrays.sort(arr);
            int firstIndex = 100000, secondIndex = 100000;
            for(int i = 0; i < n - 1 ; i++) {
                int search = m - arr[i].flavor; //5-1=4
                if(search >= arr[i].flavor) {
                    int index = binarySearch( i + 1, n - 1, arr, search);
                    if( index != -1 ) {
                        System.out.println( Math.min(arr[i].index, index) + " " + Math.max(arr[i].index, index));
                        break;

                    }
                }
            }

        }

    }

}