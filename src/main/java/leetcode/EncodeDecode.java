package leetcode;

/**
 * Created by Joshua on 6/4/17.
 */
public class EncodeDecode {
    private static String base64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()[]"; //42 - 64 = 12

/*    public String encode64(String s) {
        StringBuffer buffer = new StringBuffer();

        if (s.length()%3 != 0) {
            for (int i=(s.length()%3); i< 3; i++) {
                s+=" ";
            }
        }

        char[] c = s.toCharArray();
        for (int i=0; i<c.length; i+=3) {
            int v = c[i] + c[i+1] + c[i+2];

        }
    }

    public String decode(String s) {

    }*/
}
