package leetcode.java;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


/**
 * Created by joshua.chi on 5/23/17.
 */
public class LonelyInteger {
    public static void main(String[] args) {
        int[] a = new int[]{1,1,2,2,3,4,4};
        System.out.println(lonelyInteger(a));
    }

    private static int lonelyInteger(int[] a) {

        System.out.println(0^3);

        int r = Arrays.stream(a).reduce(0, (x, y) -> (x^y));
        System.out.println(r);
        return r;
    }
}
