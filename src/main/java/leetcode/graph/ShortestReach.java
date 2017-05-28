package leetcode.graph;
import java.util.HashSet;
import java.util.Scanner;
/**
 * Created by Joshua on 5/24/17.
 */
public class ShortestReach {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i=0; i<q; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] map = new int[n][n];

            //2-1;2-3;2-4;
            for (int j=0; j<m; j++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                map[u-1][v-1] = 6;
                map[v-1][u-1] = 6;
            }
            int startNode = scanner.nextInt();
            int[][] result = new int[n][n];
            HashSet<String> visited = new HashSet();
            BFS(map, startNode-1, 1, result, visited);
            for (int k = 0; k < n; k++) {
                if (k!=(startNode-1)) {
                    System.out.print((result[startNode-1][k]==0?-1:result[startNode-1][k]) + " ");
                }
            }
            System.out.print("\n");
        }
        scanner.close();
    }

    public static void BFS(int[][] map, int startNode, int index, int[][] result, HashSet<String> visited) {
        int count = 0;
        while (count < map.length) {
            if (count != startNode) {
                String key1 = String.format("%s-%s", count, startNode);
                String key2 = String.format("%s-%s", startNode, count);
                if (visited.contains(key2) == false  && visited.contains(key1) == false && (map[startNode][count] > 0 || map[count][startNode] > 0)) {
                    visited.add(key1);
                    visited.add(key2);
                    result[count][startNode] = index * 6;
                    result[startNode][count] = index * 6;
                    //System.out.println(count);
                    BFS(map, count, index+1, result, visited);
                }
            }
            count++;
        }

    }
}
