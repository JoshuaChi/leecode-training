package string;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created by joshua.chi on 6/5/17.
 */
public class Compressor {

    public String compress(String str) {
        int capibility = 2;

        if (str.length() < 1) {
            return "";
        }
        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
        char[] charArray = str.toCharArray();

        for (int i=0; i<charArray.length; i++) {
            char c = charArray[i];
            int count = 0;
            if (linkedHashMap.containsKey(c)) {
                count = linkedHashMap.get(c);
            }
            linkedHashMap.put(c, count+1);
        }

//        StringBuffer buffer = getStringBuffer(capibility, linkedHashMap);

//        return buffer.toString();
        return getStringBuffer(charArray);
    }

    private String getStringBuffer(char[] charArray) {
        StringBuffer buffer = new StringBuffer();
        Character prev = null;
        int preCount = 0;
        for (int i=0; i<charArray.length; i++) {
            char c = charArray[i];

            if (prev == null ) { // first character
                preCount = 1;
                prev = c;
            }
            else if (prev.equals(c)) {
                preCount++;
            }
            else {
                if (preCount < 2) {
                    buffer.append(prev);
                }
                else {
                    buffer.append(prev).append("{" + preCount +"}");
                }
                preCount = 1;
                prev = c;
            }
        }
        if (preCount < 2) {
            buffer.append(prev);
        }
        else {
            buffer.append(prev).append("{" + preCount +"}");
        }
        return buffer.toString();

    }
    private StringBuffer getStringBuffer(int capibility, LinkedHashMap<Character, Integer> linkedHashMap) {
        StringBuffer buffer = new StringBuffer();
        Iterator i = linkedHashMap.entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry next = (Map.Entry) i.next();
            char c = (char) next.getKey();
            int count = (int) next.getValue();
            if (count >= capibility) {
                buffer.append(c).append("{" + count +"}");
            }
            else {
                if (capibility > 1) {
                    for (int t=0; t< count; t++) {
                        buffer.append(c);
                    }
                }
                else {
                    buffer.append(c);
                }
            }
        }
        return buffer;
    }

    @Test
    public void testCompress() {

        String ts1 = "aaaabb";
        String r = compress(ts1);
        assertTrue(r.equals("a{4}b{2}"));

        ts1 = "ab";
        r = compress(ts1);
        assertTrue(r.equals("ab"));

        ts1 = "";
        r = compress(ts1);
        assertTrue(r.equals(""));

        ts1 = "{}/abc";
        r = compress(ts1);
        assertTrue(r.equals("{}/abc"));

        ts1 = "abbbaab";
        r = compress(ts1);
        assertTrue(r.equals("ab{3}a{2}b"));
    }
}
