package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Joshua on 6/8/17.
 *
 Input: amount = 5, coins = [1, 2, 5]
 Output: 4
 Explanation: there are four ways to make up the amount:
 5=5
 5=2+2+1
 5=2+1+1+1
 5=1+1+1+1+1
 */
public class CoinChange {
    public int change(int amount, int[] coins) {

        if (coins.length < 1 || amount < 1) {
            return 0;
        }

        int[] counter = new int[1];
        HashSet<String> visited = new HashSet<>();

        c(amount, coins, counter, "", visited);
        return counter[0];

    }

    private void c(int amount, int[] coins, int[] counter, String key, HashSet<String> visited) {
        if (amount == 0) {
            String[] keys = key.split(";");
            List<String> l = Arrays.asList(keys);
            Collections.sort(l);
            String k = "";
            for(String s: l) {
                k += "-" + s;
            }
            if (visited.contains(k) == false) {
                counter[0] += 1;
                visited.add(k);
            }
        }

        if (amount < 0) {
            return;
        }

        for (int c: coins) {
            c(amount-c, coins, counter, c+";"+key, visited);
        }
    }

    public static void main(String[] args) {

        CoinChange c = new CoinChange();
        int[] coins = new int[]{1,2,5};
        int count = c.change(500, coins);
        System.out.print(count);
    }
}
