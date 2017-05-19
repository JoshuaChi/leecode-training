package leetcode.tree;

/**
 * Created by Joshua on 5/18/17.
 */
import java.util.Scanner;

class GFG {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int t=0; t< n; t++) {
            int k = in.nextInt();
            int i = in.nextInt();
            int j = in.nextInt();
            System.out.println(String.format("%.6f", output(k, i, j)));
        }
    }

    public static double output(int k, int i, int j) {
        double result = 0;
        if (k<0 || i<1 || j<1) {
            return result;
        }
        int row = 0;
        int lastRow = 0;
        while(k > 0) {
            int nodes = calNodesAtRow(row);
            if ( nodes>0 && k/nodes > 1) {
                k = k-nodes;
                row++;
            }
            else {
                result = Double.valueOf(k) / Double.valueOf(nodes);
                lastRow = row;
                break;
            }
        }

        if (lastRow > i-1) {
            result = 1;
        }
        else if(lastRow < i-1) {
            result = 0;
        }
        return result;
    }

    public static int calNodesAtRow(int row) {
        return (int)Math.pow(2, row);
    }



}
