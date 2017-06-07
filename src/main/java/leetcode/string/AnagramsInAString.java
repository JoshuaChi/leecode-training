package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshua.chi on 6/7/17.
 */
public class AnagramsInAString {
    /**
     * count == 0, means no pattern char found in window;
     * count == p.size, means no pattern char found in window, we need increase right;
     * Always move window, to find matches
     * count is resource, which could be consumed out inside this window
     *
     *
     * @param s abc
     * @param p b
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> l = new ArrayList<>();

        if (s.length() < 1 || p.length() < 1) {
            return l;
        }

        int[] pt = new int[26];
        for (char c: p.toCharArray()) {
            pt[c-'a'] ++;
        }
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            char targetChar = s.charAt(right);
            if (pt[targetChar-'a'] > 0) {
                count--;
            }
            pt[targetChar-'a']--;
            right++;

            if (count == 0) {
               l.add(left);
            }

            if (right - left == p.length()) {
                if (pt[s.charAt(left)-'a'] >= 0) {
                    count++;
                }
                pt[s.charAt(left)-'a']++;
                left ++;
            }
        }

        return l;
    }

    public static void main(String[] args) {
        AnagramsInAString anagramsInAString = new AnagramsInAString();
        List<Integer> l = anagramsInAString.findAnagrams("abbcdba", "ab");
        for (Integer i: l) {
            System.out.println(i);
        }
    }
}
