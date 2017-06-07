package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joshua on 6/6/17.
 */

/**
 1. Use two pointers: start and end to represent a window.
 2. Move end to find a valid window.
 3. When a valid window is found, move start to find a smaller window.
 */
public class SlidingWindow {
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;

        int[] hash = new int[26]; //character hash

        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c-'a']++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right)-'a'] >= 1) {
                count--;
            }
            hash[s.charAt(right)-'a']--;
            System.out.println("R: " + s.charAt(right) + " = " + hash[s.charAt(right)-'a'] + ". Right: " + (right+1));
            right++;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) {
                list.add(left);
            }
            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() ) {


                if (hash[s.charAt(left)-'a'] >= 0) {
                    count++;
                }
                hash[s.charAt(left)-'a']++;
                left++;
                System.out.println("L: " + s.charAt(left) + " = " + hash[s.charAt(left)-'a'] + " . Left: " + left);

            }


        }
        return list;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> r = new ArrayList<>();

        int[] pattern = new int[30];
        for (char c: p.toCharArray()) {
            pattern[c-'a'] ++;
        }
        int left=0;
        int right=0;
        int count = p.length();

        while (right < s.length()) {
            if(pattern[s.charAt(right)-'a'] >= 1 ) {
                count --;

            }
            pattern[s.charAt(right)-'a'] -= 1;
            right ++;

            if (count == 0) {
                r.add(left);
            }

            if (right - left == p.length()) {
                if (pattern[s.charAt(left)-'a'] >= 0) {
                    count++;
                }
                pattern[s.charAt(left)-'a']++;
                left++;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        SlidingWindow slidingWindow = new SlidingWindow();

        List<Integer> list = slidingWindow.findAnagrams("abbba", "ab");
    }
}
