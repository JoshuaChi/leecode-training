package leetcode.kpm;

/**
 * Created by joshua.chi on 5/23/17.
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String text = scanner.next();
            String target = scanner.next();

            char[] textAry = text.toCharArray();
            char[] targetAry = target.toCharArray();

            int count = cal(textAry, targetAry);
            System.out.println(((count > 0) ? "found" : "not found") + count);
        }
    }

    public static int cal(char[] text, char[] target) {
        int[] dict = generateLPSarray(target);
        int index = 0;
        int count = 0;
        while (index < text.length) {
            boolean has = true;
            int length = target.length;
            int move = 0;
            for (int j = 0; j < length; j++) {
                if ((index + j) >= text.length || target[j] != text[index + j]) {
                    has = false;
                    move = dict[j];
                }
            }
            if (has) {
                count++;
            }

            index += (move == 0) ? 1 : move;
        }
        return count;
    }

    public static int factorial(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static boolean compare(char[] a1, char[] a2) {
        if (a1.length != a2.length) {
            return false;
        }
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] generateLPSarray(char[] target) {
        int len = target.length;
        int[] dict = new int[len];
        int suffix = len - 1;
        int count = 0;
        while (suffix > 0) {
            if (target[0] == target[len - 1 - count]) {
                int subLen = count + 1;
                char[] a1 = new char[subLen];
                char[] a2 = new char[subLen];
                System.arraycopy(target, 0, a1, 0,  subLen);
                System.arraycopy(target, len - 1 - count, a2, 0, subLen);
                if (compare(a1, a2)) {
                    dict[count] = factorial(count);
                }
            } else {
                break;
            }
            count++;
            suffix--;
        }
        return dict;
    }
}