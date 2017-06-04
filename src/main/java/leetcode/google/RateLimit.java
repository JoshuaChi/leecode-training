package leetcode.google;

import java.util.HashMap;

/**
 * Created by Joshua on 6/4/17.
 */
public class RateLimit {

    private static HashMap<String, Long> map = new HashMap<>();
    /**
     *
     * @param text
     * @param timestamp second
     * @return
     */
    public boolean log(String text, Long timestamp) {
        if (map.containsKey(text) == false) {
            map.put(text, timestamp);
            return true;
        }
        else {
            Long t = map.get(text);
            if (timestamp - t > 10) {
                map.put(text, timestamp);
                return true;
            }
        }
        return false;
    }
}
