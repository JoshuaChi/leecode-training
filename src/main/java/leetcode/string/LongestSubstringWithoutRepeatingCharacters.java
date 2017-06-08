package leetcode.string;

/**
 * Created by joshua.chi on 6/7/17.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     Given "abcabcbb", the answer is "abc", which the length is 3.
     Given "bbbbb", the answer is "b", with the length of 1.
     Given "pwwkew", the answer is "wke", with the length of 3.
        Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 1) {
            return 0;
        }

        int[] pt = new int[256];
        int right=0, left=0, count=0, len=1;
        while (right < s.length()) {
            if(count == 0) { // means there is no duplicated character in the window
                if (pt[s.charAt(right)] == 0) { // means this character never exists before;
                    if (right - left+1 > len) { // we will record the new length by comparing with old one
                        len = right - left+1;
                    }
                }
                else { // means this character exists
                    count ++; //we record the duplicated count
                }
                pt[s.charAt(right)]++; //mark this char has been visited
                right ++; // move pointer to right;
            }

            if (left <= right && count != 0) { // if there is duplicated characters
                if (pt[s.charAt(left)] > 1) { //if it is the current position
                    count--; //reduce the duplicated count
                }
                pt[s.charAt(left)]--; //get rid of duplicated
                left++; // move left pointer
            }
        }
        return len;
    }

    public static void main (String[] args) {
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        int c = l.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(c);
    }
}
