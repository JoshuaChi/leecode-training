package leetcode.graph;

import java.util.*;

/**
 * Created by joshua.chi on 5/24/17.
 */


public class RoadsAndLibraries {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt(); // cities
            int m = in.nextInt(); // roads
            int x = in.nextInt(); // lib cost
            int y = in.nextInt(); // road cost

            int[] cities = new int[n];

            int[][] map = new int[n][n];
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt(); //city 1 is connected with city 2
                int city_2 = in.nextInt();
                map[city_1-1][city_2-1] = 1;
                map[city_2-1][city_1-1] = 1;

                cities[city_1-1] = 1;
                cities[city_2-1] = 1;
            }
            HashSet<String> visited = new HashSet<>();
            long cost = cal(map, x ,y, visited);
            for (int i=0;i<cities.length;i++) {
                if (0 == cities[i]) {
                    cost += x;
                }
            }
            System.out.println(cost);
        }
        in.close();
    }

    private static long cal(int[][] map, int libCost, int roadCost, HashSet<String> visited) {
        int cost = 0;
        for (int i=0; i<map.length; i++) {
            for (int j=0; j< map[0].length; j++) {
                String key = key(i, j);
                String reversedKey = key(j, i);
                if ( (false == visited.contains(key)) &&  (false == visited.contains(reversedKey))) {
                    HashSet<Integer> set = getIsland(map, i, j, visited);
                    if (set.size() > 0) {
                        if (libCost >= roadCost) {
                            cost += roadCost * (set.size()-1) + libCost;
                        }
                        else {
                            cost += libCost * set.size();
                        }
                    }
                }
            }

        }
        return cost;
    }

    private static String key(int x, int y) {
        return String.format("%s-%s",x,y);
    }

    private static HashSet<Integer> getIsland(int[][] map, int x, int y, HashSet<String> visited) {
        String key = key(x,y);
        String reveredKey = key(y,x);

        int originalX = x;
        int originalY = y;
        if (visited.contains(key) || visited.contains(reveredKey)) {
            return new HashSet<>();
        }else {
            //mark this cell is visited;
            visited.add(key);
            visited.add(reveredKey);
        }

        //A set keeps all connected islands.
        HashSet<Integer> set = new HashSet<>();
        x = originalX+1;
        y = originalY;
        generate(map, x, y, visited, set);
        x = originalX+1;
        y = originalY+1;
        generate(map, x, y, visited, set);
        x = originalX+1;
        y = originalY-1;
        generate(map, x, y, visited, set);
        x = originalX;
        y = originalY-1;
        generate(map, x, y, visited, set);
        x = originalX;
        y = originalY+1;
        generate(map, x, y, visited, set);
        x = originalX-1;
        y = originalY-1;
        generate(map, x, y, visited, set);
        x = originalX-1;
        y = originalY;
        generate(map, x, y, visited, set);
        x = originalX-1;
        y = originalY+1;
        generate(map, x, y, visited, set);
        return set;
    }

    private static void generate(int[][] map, int x, int y, HashSet<String> visited, HashSet<Integer> set) {
        String key;
        key = key(x, y);
        if (x>=0 && x< map.length && y>=0 && y<map.length &&
                map[x][y] == 1 && visited.contains(key) == false) {
            set.add(x);
            set.add(y);
            HashSet<Integer> tmpSet = getIsland(map, x, y, visited);
            tmpSet.forEach(a -> set.add(a));
        }
    }

}
