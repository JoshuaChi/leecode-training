package leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by joshua.chi on 6/2/17.
 */
public class UniquePath {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int lengthY = obstacleGrid[0].length;
        int lengthX = obstacleGrid.length;

        if (lengthX < 1 || lengthY < 1) {
            return 0;
        }
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = 1;
                } else if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                }
            }
        }

        obstacleGrid[0][0] = 1;


        for (int i = 0; i < lengthX; i++) {
            for (int j = 0; j < lengthY; j++) {
                if (i == 0 && j == 0) {
                    obstacleGrid[i][j] = 1;
                } else {
                    if (obstacleGrid[i][j] == 0) {
                        continue;
                    }

                    if ((i - 1) >= 0 && (j - 1) >= 0) {

                        obstacleGrid[i][j] = (obstacleGrid[i - 1][j] == 0 ? 0 : obstacleGrid[i - 1][j]) + (obstacleGrid[i][j - 1] == 0 ? 0 : obstacleGrid[i][j - 1]);
                    } else if ((i - 1) >= 0) {
                        obstacleGrid[i][j] = (obstacleGrid[i - 1][j] == 0 ? 0 : obstacleGrid[i - 1][j]);
                    } else if ((j - 1) >= 0) {
                        obstacleGrid[i][j] = (obstacleGrid[i][j - 1] == 0 ? 0 : obstacleGrid[i][j - 1]);
                    }
                }
            }
        }
        int row = lengthX - 1;
        int col = lengthY - 1;
        return obstacleGrid[row][col];
    }

    public static void main(String[] args) {
        UniquePath uniquePath = new UniquePath();
        int[][] ary = new int[1][2];
        ary[0][1] = 1;
        int c = uniquePath.uniquePathsWithObstacles(ary);
        System.out.println(c);
    }

}
