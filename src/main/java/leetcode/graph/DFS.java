package leetcode.graph;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Joshua on 5/14/17.
 */
public class DFS {

    public static class Element {
        int x;
        int y;
        public Element(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int getBiggestRegion(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        HashSet visited = new HashSet();

        int regions = 0;
        for (int i=0; i< rows; i++) {
            for (int j=0; j<cols; j++) {
                if (validate(matrix, rows, cols, i, j, visited)) {
                    Stack<Element> stack = new Stack();
                    stack.push(new Element(i, j));
                    int count = 0;
                    count = query(matrix, rows, cols, visited, stack);
                    if (count > regions) {
                        regions = count;
                    }
                }
            }
        }
        return regions;
    }

    private static int query(int[][] matrix, int rows, int cols, HashSet visited, Stack<Element> stack) {
        int count = 0;
        if (stack.isEmpty() == false) {
            Element element = stack.pop();
            int x = element.x;
            int y = element.y;
            visited.add(String.format("%s-%s", x, y));
            count++;

            int i = x;
            int j = y - 1;
            getCount(matrix, rows, cols, visited, stack, count, i, j);
            j = y + 1;
            getCount(matrix, rows, cols, visited, stack, count, i, j);
            i = x - 1;
            j = y;
            getCount(matrix, rows, cols, visited, stack, count, i, j);
            j = y - 1;
            getCount(matrix, rows, cols, visited, stack, count, i, j);
            j = y + 1;
            getCount(matrix, rows, cols, visited, stack, count, i, j);
            i = x + 1;
            j= y;
            getCount(matrix, rows, cols, visited, stack, count, i, j);
            j = y - 1;
            getCount(matrix, rows, cols, visited, stack, count, i, j);
            j = y + 1;
            getCount(matrix, rows, cols, visited, stack, count, i, j);

            count += query(matrix, rows, cols, visited, stack);
        }

        return count;
    }

    private static void getCount(int[][] matrix, int rows, int cols, HashSet visited, Stack<Element> stack, int count, int i, int j) {
        if (validate(matrix, rows, cols, i, j, visited)) {
            stack.push(new Element(i, j));
            visited.add(String.format("%s-%s", i, j));
        }
        else if (notVisited(rows, cols, i, j, visited)){
            visited.add(String.format("%s-%s", i, j));
        }
    }

    private static boolean validate(int[][] matrix, int rows, int cols, int x, int y, HashSet<Element> visited) {
        if (notVisited(rows, cols, x, y, visited) && (1 == matrix[x][y])) {
            return true;
        }
        return false;
    }

    private static boolean notVisited(int rows, int cols, int i, int j, HashSet visited) {
        if (i >= 0 && i < rows && j >= 0 && j < cols && false == visited.contains(String.format("%s-%s", i, j))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }
}
