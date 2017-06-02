package leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by joshua.chi on 6/2/17.
 */
public class UniquePath {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //start from 0x0, end at 3x3, if length is 4
        //use visited to track visited node in each try
        //we loop all tries by using dp, giving a node and visited,
        // for each try, we record the visited node in order with a Set
        //At last, we will loop the set and find item.length == 4 and count items

        //step1: giving a node, try the 8 directions,
        //  if the current node indexX==3 and indexY==3, stop.


        HashMap<String, HashSet<String>> visited = new HashMap<>();
        HashSet<String> roads = new HashSet<>();

        loop(obstacleGrid,0,0,roads, "", visited);

        return roads.size();
    }

    public void loop(int[][] ary, int x, int y,
                     HashSet<String> roads,
                     String path,
                     HashMap<String, HashSet<String>> visited) {

        int xlen = ary.length;
        int ylen = ary[0].length;

        if (x<0 ||y<0 ||x >=xlen || y>=ylen) {
            return;
        }

        if (ary[x][y] == 1) {
            return;
        }

        String key = key(x, y);
        String newPath = key(path, x, y);

        //if it's the exist, we will record this road;
        if ( ary[x][y] == 0 && x == (xlen-1) && y == (ylen-1) ) {
            roads.add(newPath);
            return;
        }

        HashSet<String> visitedCells = visited.get(path);
        if (visitedCells == null) {
            visitedCells = new HashSet<>();
        }

        if (visitedCells.contains(key)) {
            return;
        }

        //added into visited
        visitedCells.add(key);
//        visited.remove(path);
        visited.put(newPath, visitedCells);

        //try different directions
        //loop(ary, x, y-1, roads, newPath, visited);
        loop(ary, x, y+1, roads, newPath, visited);
        //loop(ary, x-1, y-1, roads, newPath, visited);
        //loop(ary, x-1, y, roads, newPath, visited);
        //loop(ary, x-1, y+1, roads, newPath, visited);
        //loop(ary, x+1, y-1, roads, newPath, visited);
        loop(ary, x+1, y, roads, newPath, visited);
        //loop(ary, x+1, y+1, roads, newPath, visited);

    }

    public String key(int x, int y) {
        return String.format("%s-%s", x, y);
    }

    public String key(String x, int i, int j) {
        return String.format("%s->%s%s", x, i, j);
    }

    public static void main(String[] args) {
        UniquePath uniquePath = new UniquePath();
        int[][] ary = new int[5][4];
        ary[1][1] = 1;
        ary[3][2] = 1;

        int c = uniquePath.uniquePathsWithObstacles(ary);
        System.out.println(c);
    }
}
