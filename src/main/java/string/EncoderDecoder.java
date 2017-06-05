package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshua.chi on 6/5/17.
 */
public class EncoderDecoder {
    private static String base64String = "ABCDEFGHIJKLMNOPQRSTUVWXYZzbcdefghijklmnopqrstuvwxyz0123456789"; //64bits

/*    public String encode(String str) {
        if (str.length() %3 != 0 ) {
            for (int i = str.length()%3; i<3; i++) {
                str += "=";
            }
        }

        char[] a = str.toCharArray();
        for (int i=0; i<a.length; i+=3) {
            int r = a[i] + a[i+1] + a[i+2];

        }
    }*/

    public String encode(List<String> strs) {
        StringBuffer buffer = new StringBuffer();

        for (String s: strs) {
            buffer.append(s.length()).append("/").append(s);
        }
        return buffer.toString();

    }

    public List<String> decode(String s) {
        List<String> strs = new ArrayList<>();
        int i=0;
        while (i<s.length()) {
            int index = s.indexOf("/", i);
            int size = Integer.parseInt(s.substring(i, index));
            String subStr = s.substring(i+2, i+2+size);
            strs.add(subStr);
            i += 2 + size;
        }
        return strs;
    }
    
    // Encodes a list of strings to a single string.
    public String encode2(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode2(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            ret.add(s.substring(slash + 1, slash + size + 1));
            i = slash + size + 1;
        }
        return ret;
    }

    public static void main(String[] args) {

        EncoderDecoder encoderDecoder = new EncoderDecoder();
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("ẞ/X12/");
        list.add("C");
        String es = encoderDecoder.encode(list);
        System.out.println(es);
        List<String> l = encoderDecoder.decode(es);
        for (String ss: l) {
            System.out.println(ss);
        }
    }
}
