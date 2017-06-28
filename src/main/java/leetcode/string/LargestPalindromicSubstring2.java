package leetcode.string;


/**
 * Created by joshua.chi on 6/27/17.

 Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example:

 Input: "babad"

 Output: "bab"

 Note: "aba" is also a valid answer.
 Example:

 Input: "cbbd"

 Output: "bb"
 Seen this question in a real interv

 http://blog.csdn.net/camellhf/article/details/70337501
 */
public class LargestPalindromicSubstring2 {
    private int pos = 0;
    private int maxLen = 0;

    public static void main(String[] args) {
        LargestPalindromicSubstring2 l = new LargestPalindromicSubstring2();
//        String text = "abbbbbbbaccdd";
        String text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        l.findLargestPalindromicSubstring(text);


    }

    private String populateText(String text) {
        StringBuffer buffer = new StringBuffer();
        char split = '$';
        buffer.append(split);
        for (char c: text.toCharArray()) {
            buffer.append(c);
            buffer.append(split);
        }
        return buffer.toString();
    }

    public void findLargestPalindromicSubstring(String text) {
        text = populateText(text);
        this.find(text);
        String substring = text.substring(pos - maxLen, pos + maxLen + 1);
        substring = substring.replaceAll("\\$", "");
        System.out.println(substring);
    }

    public void find(String text) {
        int length = text.length();
        for (int i = 0; i< length; i++) {
            int palindromicLength = Math.min(i, length-i-1);
            for (int l = palindromicLength; l >=0; l--) {
                if (f(text, i, l)) {
                    if (l > maxLen) {
                        pos = i;
                        maxLen = l;
                    }
                }
            }
        }

    }

    //text = "abbacd" index=1 len=1;
    private boolean f(String text, int index, int len) {
        if (len < 1) {
            return false;
        }
        for (int l = len; l>=0; l--) {
            if (text.charAt(index-l) != text.charAt(index+l)) {
                return false;
            }
        }
        return true;
    }

}
