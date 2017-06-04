package leetcode.list;

import java.util.ArrayList;

/**
 * Created by Joshua on 6/3/17.
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int max = 0;

        ArrayList<Character> list = new ArrayList<>();
        int i=0;
        while (i < chars.length) {
            char c = chars[i];
            if (false == list.contains(c)) {
                System.out.print(c +" ");
                list.add(c);
            }
            else {
                if (list.size() > max) {
                    max = list.size();
                    System.out.println("\n max: " + max);
                }
                System.out.println(" ");

                while(list.isEmpty() == false) {
                    Character toBeDeleted = list.get(0);
                    System.out.println("toBeDeleted: " + toBeDeleted);
                    if ((char)toBeDeleted != c) {
                        list.remove(0);
                    }
                    else {
                        System.out.println("1:list.size(): " + list.size());
                        list.remove(0);
                        System.out.println("2:list.size(): " + list.size());
                        break;
                    }
                }
                System.out.print(c +" ");
                list.add(c);
            }

            i++;
        }

        return max < list.size()? list.size():max;
    }

    public static void main(String[] args) {

        System.out.print(lengthOfLongestSubstring("pwwkew"));

    }

}
