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
            HashMap<Long, HashSet<Long>> cities = new HashMap<>();

            for (int a1 = 0; a1 < m; a1++) {
                long city_1 = in.nextInt(); //city 1 is connected with city 2
                long city_2 = in.nextInt();

                long i = city_1 - 1;
                long e = city_2 - 1;

                init(cities, e, i);
                init(cities, i, e);
            }

            long cost = x * n;
            if(x > y) {
                HashSet<Long> visited = new HashSet<>();
                cost = cal(cities, x, y, visited);

                for (long i = 0; i < n; i++) {
                    if (cities.containsKey(i) == false) {
                        cost += x;
                    }
                }

            }

            System.out.println(cost);
        }
        in.close();
    }

    private static void init(HashMap<Long, HashSet<Long>> cities, Long i, Long e) {
        if (cities.containsKey(e)) {
            HashSet<Long> set = cities.get(e);
            set.add(i);
            cities.put(e, set);
        }
        else {
            HashSet<Long> set = new HashSet<>();
            set.add(i);
            cities.put(e, set);
        }
    }

    private static long cal(HashMap<Long, HashSet<Long>> cities, int libCost, int roadCost, HashSet<Long> visited) {
        long cost = 0;
        Iterator i = cities.entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry<Long, HashSet<Long>> entry = (Map.Entry<Long, HashSet<Long>>)i.next();
            Long city = entry.getKey();
            HashSet<Long> set = entry.getValue();

            if (visited.contains(city) == false) {
                final long[] count = new long[1];
                set.forEach(x -> DFS(cities, x, visited, count));
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

    private static void DFS(HashMap<Long, HashSet<Long>> cities, Long city, HashSet<Long> visited, final long[] count) {

        if (visited.contains(city)) {
            return;
        }
        visited.add(city);
        if (cities.containsKey(city)) {
            count[0] ++;
            HashSet<Long> set = cities.get(city);
            set.forEach(i -> {
                        if (visited.contains(i) == false) {
                            DFS(cities, i, visited, count);
                        }
                    }
            );
        }

    }

}
