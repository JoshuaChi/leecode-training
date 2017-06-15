package leetcode.search;

import java.util.*;

/**
 * Created by joshua.chi on 6/12/17.
 */
public class ShortestReachInAGraph1 {
    public static class Graph {
        ArrayList<HashSet<Integer>> list;
        private int count;

        private int distance = 6;

        public Graph(int size) {
            count = size;
            list = new ArrayList<>();
            for (int i=0; i<size; i++) {
                HashSet<Integer> set = new HashSet<>();
                list.add(i, set);
            }
        }

        public void addEdge(int first, int second) {
            HashSet<Integer> set = list.get(first);
            set.add(second);
            set = list.get(second);
            set.add(first);
        }

        public int[] shortestReach(int startId) { // 0 indexed
            int[] result = new int[count];
            Arrays.fill(result, -1);

            LinkedList<Integer> queue = new LinkedList();
            queue.add(startId);
            bfs(result, queue);

            return result;
        }

        public void bfs(int[] result, LinkedList<Integer> queue) {
            while(queue.isEmpty() == false) {
                int index = queue.remove();

                HashSet<Integer> group = list.get(index);
                for (int i: group) {
                    if (result[i] == -1) {
                        result[i] = result[index] + distance;
                        queue.add(i);
                    }

                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
