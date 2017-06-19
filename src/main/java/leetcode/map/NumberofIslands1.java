package leetcode.map;

/**
 * Created by Joshua on 6/19/17.
 */
// Java program to fnd number of islands using Disjoint
// Set data structure.
import java.io.IOException;

public class NumberofIslands1
{
    public static void main(String[] args)throws IOException
    {
        int[][] a = new int[][] {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println("Number of Islands is: " +
                countIslands(a));
        for (int i=0; i<a.length ;i++) {
            for (int j=0; j<a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int countIslands(int[][] a) {
        int cursor = 0;
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a[0].length; j++) {
                int cell = a[i][j];

                if (cell == 1) {
                    int count = getCountFromTopLeft(a, i, j);
                    if(count == 0) {
                        a[i][j] = ++cursor;
                    }
                    else {
                        a[i][j] = count;
                    }
                }

            }
        }
        return cursor;
    }

    private static int getCountFromTopLeft(int[][] a, int i, int j) {

        if (i-1 >=0 && a[i-1][j] > 0) {
            return a[i-1][j];
        }
        if (j-1>=0 && a[i][j-1] > 0) {
            return a[i][j-1];
        }
        if (i-1 >=0 && j-1>=0 && a[i-1][j-1] > 0) {
            return a[i-1][j-1];
        }
        if (i-1 >=0 && j+1 < a[0].length && a[i-1][j+1] > 0) {
            return a[i-1][j+1];
        }
        return 0;
    }

}