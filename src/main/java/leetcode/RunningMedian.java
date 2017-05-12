package leetcode;

import java.util.Scanner;

/**
 * Created by Joshua.Chi <joshua.chi@akqa.com>
 *
 * @author joshua.chi
 * @date 5/12/17
 */
public class RunningMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        RunningMedian runningMedian = new RunningMedian();

        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            runningMedian.cal(a.clone(), a_i+1);
        }
    }

    private void cal(int[] a, int length) {
        sort(a, length);
        final int i = length / 2;
        if (length % 2 == 0) {
            final double average = (Double.valueOf(a[i - 1]) + Double.valueOf(a[i])) / 2;
            System.out.printf("%.2f\n", average);
        }
        else {
            final double average = a[i];
            System.out.printf("%.2f\n", average);
        }
    }

    private void sort(int[] a, int index) {
        for (int i=0; i<index; i++) {
            boolean hasSwap = false;
            for(int j=i+1; j<index; j++) {
                if (a[i]> a[j]) {
                    swap(a, i, j);
                    hasSwap = true;
                }
            }
            if (false == hasSwap) {
                return;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
