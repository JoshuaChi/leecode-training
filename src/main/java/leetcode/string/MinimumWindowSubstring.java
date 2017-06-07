package leetcode.string;

import leetcode.sort.quick.MinHeap;

/**
 * Created by joshua.chi on 6/7/17.
 */
public class MinimumWindowSubstring {
    /**
     *
     扩展窗口，窗口中包含一个T中子元素，count–；
     通过count或其他限定值，得到一个可能解。
     只要窗口中有可能解，那么缩小窗口直到不包含可能解。
     * @param s
     * @param p
     * @return
     */
    public String min(String s, String p) {
        int[] pt = new int[26];
        for (char c: p.toCharArray()) {
            pt[c-'a'] ++;
        }
        int left = 0, right = 0, count = p.length(), len=Integer.MAX_VALUE, trackIndex=0;
        while (right < s.length()) {
            if (pt[s.charAt(right)-'a'] > 0) {
                count--;
            }

            pt[s.charAt(right)-'a'] --;
            right++;

            while (left <= right && count == 0) {
                if (pt[s.charAt(left)-'a'] >= 0) {
                    count++;

                    if (right - left < len) {
                        trackIndex = left;
                        int newLen = right - left;
                        len = newLen;
                    }
                }


                pt[s.charAt(left)-'a']++;
                left++;
            }
        }
        if (len == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(trackIndex, trackIndex+len);
    }

    public static void main (String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        String s = m.min("axxxxbdacdbhxa", "ba");
        System.out.println(s);
    }
}
