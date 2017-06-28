package leetcode.string;


/**
 * Created by Joshua on 6/15/17.
 * http://blog.csdn.net/camellhf/article/details/70337501
 */
public class LargestPalindromicSubstring2 {
    private int pos = 0;
    private int maxLen = 0;
    private int[] tracking;

    public static void main(String[] args) {
        LargestPalindromicSubstring2 l = new LargestPalindromicSubstring2();
//        String text = "abbbbbbbaccdd";
        String text = "babad";
        l.findLargestPalindromicSubstring(text);


    }

    public void findLargestPalindromicSubstring(String text) {
        this.find(text);
        System.out.println(text.substring(pos-maxLen, pos+maxLen+1));
    }


    public void find(String text) {
        int length = text.length();
        tracking = new int[length];
        for (int i = 0; i< length; i++) {
            char c = text.charAt(i);
            int palindromicLength = Math.min(i, length-i-1);
            if (f(text, i, palindromicLength)) {
                if (palindromicLength > maxLen) {
                    pos = i;
                    maxLen = palindromicLength;
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
