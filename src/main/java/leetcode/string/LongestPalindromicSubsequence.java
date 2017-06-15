package leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by joshua.chi on 6/15/17.
 *
 Sample Input
 3
 1 1
 a
 3 2
 aab
 3 0
 aba


 Sample Output
 2
 1
 104
 */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for (int i=0; i<q; i++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String s = scanner.next();
            System.out.println(calculate(s, n, k));
        }

    }

    public static int calculate(String s, int n, int k) {
        if (k == 0) {
            return 26 * (s.length()+1);
        }
        int count = 0;

        char first = s.charAt(0);
        char last = s.charAt(s.length()-1);

        HashMap<String, Integer> cache = new HashMap<>();
        int oldLen = c(s, 0, s.length(), cache);
        String str2 = new StringBuffer().append(first).toString();
        if (first != last) {
            str2 = new StringBuffer().append(first).append(last).toString();
        }

        for (char c: str2.toCharArray()) {
            String newS = c + s;
            int newLen = c(newS, 0, newS.length(), cache);
            if (newLen - oldLen == k) {
                count++;
            }
            newS = s + c;
            newLen = c(newS, 0, newS.length(), cache);
            if (newLen - oldLen == k) {
                count++;
            }

        }
        return count;
    }


    public static int c(String s, int start, int end, HashMap<String, Integer> cache) {
         //if [0] == len-1
        //else (0, len-2), (1, len-1)

        int len = end - start; //[0,1,2] 0-3 [0],0-1,
        if (len < 1) {
            return 0;
        }
        if (len == 1) {
            return 1;
        }

        String subStr = s.substring(start, end);
        if (cache.containsKey(subStr)) {
            return cache.get(subStr);
        }

        if (s.charAt(start) == s.charAt(end - 1)) {
            int c = 2 + c(s, start+1, end-1, cache);
            cache.put(subStr, c);
            return c;
        }
        else {
            int c = Math.max(c(s, start, end-1, cache), c(s, start+1, end, cache));
            cache.put(subStr, c);
            return c;
        }
    }


}
