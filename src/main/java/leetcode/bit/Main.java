package leetcode.bit;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Joshua on 6/4/17.
 */
public class Main {
    @Test
    public void testMain() {

        int a = 3;
        int b = 1;
        int c = a ^ b; //2
        assertTrue(c == 2);
        int d = a>>1; // 1
        assertTrue(d == 1);
        int e = a << 1; //6
        assertTrue(e == 6);
        int h = -3;
        //-3 = [100000011]
        //-> [1111111100]
        //-> [11111111]
        //-> [10000000]
        //-> [10000001]
        int h1 = h >> 2; //-1
        assertTrue(h1 == -1);

        c = a&b;
        assertTrue(c==1);
        c = a|b;
        assertTrue(c==3);
        assertTrue(a==3);
        a = 3;
        c = ~a; // 0011
        assertTrue(c == -4);
        a = 9;
        c = ~a; // 0011
        assertTrue(c == -10);

    }
}
