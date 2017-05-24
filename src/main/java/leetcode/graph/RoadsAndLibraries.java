package leetcode.graph;

import java.util.*;

/**
 * Created by joshua.chi on 5/24/17.
 */


public class RoadsAndLibraries {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();


        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt(); // cities
            int m = in.nextInt(); // roads
            int x = in.nextInt(); // lib cost
            int y = in.nextInt(); // road cost

            HashSet<Integer>[] cities = new HashSet[n];

            for (int i=0; i<cities.length; i++) {
                cities[i] = new HashSet<>();
            }
            for (int a1 = 0; a1 < m; a1++) {
                int city_1 = in.nextInt(); //city 1 is connected with city 2
                int city_2 = in.nextInt();

                int i = city_1 - 1;
                int e = city_2 - 1;

                cities[i].add(e);
                cities[e].add(i);
            }
            HashSet<Integer> visited = new HashSet<>();
            long cost = cal(cities, x, y, visited);
            for (int i = 0; i < cities.length; i++) {
                if (cities[i].isEmpty()) {
                    cost += x;
                }
            }
            System.out.println(cost);
        }
        in.close();
    }

    private static long cal(HashSet<Integer>[] cities, int libCost, int roadCost, HashSet<Integer> visited) {
        int cost = 0;
        for (HashSet<Integer> city : cities) {
            if (visited.contains(city) == false) {
                final int[] count = new int[1];
                city.forEach(x -> DFS(cities, x, visited, count));
                if (count[0] > 0) {
                    if (roadCost >= libCost) {
                        cost += count[0] * libCost;
                    } else {
                        cost += (count[0] - 1) * roadCost + libCost;
                    }
                }
            }
        }

        return cost;
    }

    private static String key(int x, int y) {
        return String.format("%s-%s", x, y);
    }

    private static void DFS(HashSet<Integer>[] cities, Integer city, HashSet<Integer> visited, final int[] count) {

        if (visited.contains(city)) {
            return;
        }
        visited.add(city);
        if (cities[city].isEmpty() == false) {
            count[0] ++;
            HashSet<Integer> set = cities[city];
            set.forEach(i -> {
                        if (visited.contains(i) == false) {
                            DFS(cities, i, visited, count);
                        }
                    }
            );
        }

    }

}
