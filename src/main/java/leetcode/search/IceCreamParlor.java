package leetcode.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by joshua.chi on 6/12/17.
 */
public class IceCreamParlor {
    public static int binarySearch(int first, int last, IceCream[] arr, int search) {
        if (first == last && arr[first].flavor == search) {
            return arr[first].index;
        }

        if (last <= first) {
            return -1;
        }

        int mid = first + (last-first)/2; // mid=2

        if (arr[mid].flavor == search) {
            return arr[mid].index;
        }
        else if (arr[mid].flavor > search ) {//move left [1,2]
            return binarySearch(first, mid-1, arr, search);
        }
        else {//move right [3,4,5]
            return binarySearch(mid+1, last, arr, search);
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
                int search = m - arr[i].flavor;
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
