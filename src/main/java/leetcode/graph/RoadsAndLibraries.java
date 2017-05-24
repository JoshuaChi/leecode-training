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

            HashMap<Integer, HashSet<Integer>> hashmap = new HashMap<>();

            int[] nn = new int[n];
            for(int a1 = 0; a1 < m; a1++){
                int city_1 = in.nextInt(); //city 1 is connected with city 2
                int city_2 = in.nextInt();
                if (checkAdd(hashmap, city_1) == false && checkAdd(hashmap, city_2) == false) {
                    HashSet<Integer> hashSet = new HashSet<>();
                    hashSet.add(city_1);
                    hashSet.add(city_2);
                    hashmap.put(city_1, hashSet);
                    nn[city_1-1] = 1;
                }
            }
            adjust(hashmap, nn);
            int cost = cal(hashmap, x ,y);
            System.out.println(cost);
        }
    }

    private static void adjust(HashMap<Integer, HashSet<Integer>> hashmap, int[] nn) {
        for (int city: nn) {
            if(city == -1) {
                HashSet<Integer> set = new HashSet<>();
                set.add(city+1);
                hashmap.put(city+1, set);
            }
        }
    }

    public static boolean checkAdd(HashMap<Integer, HashSet<Integer>> hashmap, int key) {
        boolean contains = false;
        if (hashmap.containsKey(key)) {
            HashSet<Integer> set = hashmap.get(key);
            if (set.contains(key) == false) {
                set.add(key);
            }
            hashmap.put(key, set);
            contains = true;
        }
        return contains;
    }

    private static int cal(HashMap<Integer, HashSet<Integer>> hashmap, int libCost, int roadCost) {

        int cost = 0;
        Iterator<Map.Entry<Integer, HashSet<Integer>>> i = hashmap.entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry next = i.next();
            int key = (int) next.getKey();
            HashSet<Integer> hashSet = (HashSet<Integer>)next.getValue();

            cost += minCost(hashSet, libCost, roadCost);

        }
        //calculate connected islands
        // for each sub map(connected islands), calculate lowest cost by loop island and calculate cost for each solution

        return cost;
    }

    private static int minCost(HashSet<Integer> hashSet, int libCost, int roadCost) {
        if (hashSet.isEmpty()) {
            return 0;
        }

        int min = -1;
        for(int lib = 1; lib < hashSet.size(); lib++) {
            int cost = lib*libCost + roadCost*(hashSet.size() - lib);
            if (min == -1) {
                min = cost;
            }else {
                if (min > cost) {
                    min = cost;
                }
            }

        }
        return min;
    }

}
