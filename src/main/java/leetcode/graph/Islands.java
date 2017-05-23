package leetcode.graph;

import java.util.HashSet;

/**
 * Created by Joshua on 5/22/17.
 *
 */
// Java program to count islands in boolean 2D matrix
class Islands
{
    //No of rows and columns
    static final int ROW = 5, COL = 5;

    // A function to check if a given cell (row, col) can
    // be included in DFS
    boolean isSafe(int M[][], int row, int col,
                   boolean visited[][])
    {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL) &&
                (M[row][col]==1 && !visited[row][col]);
    }

    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 8 neighbors as adjacent vertices
    void DFS(int M[][], int row, int col, boolean visited[][])
    {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};

        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited) )
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }



    // Driver method
    public static void main (String[] args) throws java.lang.Exception
    {
        int M[][]=  new int[][] {{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        Islands I = new Islands();
        System.out.println("Number of islands is: "+ I.countIslands(M));
    }

    public int countIslands(int[][] m) {
        HashSet<String> visited = new HashSet();
        int count = 0;

        int i=0;
        while (i < m.length) {
            int j=0;
            while(j < m[0].length) {

                if(DFS(m, i, j, visited)) {
                    count++;
                }
                j++;
            }
            i++;
        }
        return count;
    }

    /**
     * for each element, we will check it's four directions
     *
     * @param m
     * @param visited
     */
    public boolean DFS(int[][] m, int x, int y, HashSet<String> visited) {
        String format = String.format("%s-%s", x, y);

        if (m[x][y] == 0 || visited.contains(format)) {
            return false;
        }

        visited.add(format);

        int[][] d = new int[8][2];
        d[0][0] = x + 1;
        d[0][1] = y;

        d[1][0] = x + 1;
        d[1][1] = y + 1;

        d[2][0] = x + 1;
        d[2][1] = y - 1;

        d[3][0] = x;
        d[3][1] = y + 1;

        d[4][0] = x;
        d[4][1] = y - 1;

        d[5][0] = x - 1;
        d[5][1] = y + 1;

        d[6][0] = x - 1;
        d[6][1] = y;

        d[7][0] = x - 1;
        d[7][1] = y - 1;

        for (int i=0; i< d.length; i++) {
            int xi = d[i][0];
            int yi = d[i][1];
            if (xi < m.length && xi >=0 && yi < m[0].length && yi >=0) {
               DFS(m, xi, yi, visited);
            }
        }
        return true;

    }

} //Contributed by Aakash Hasija
