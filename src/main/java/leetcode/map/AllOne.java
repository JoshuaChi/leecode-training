package leetcode.map;

import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by joshua.chi on 6/8/17.
 */
public class AllOne {

    private Row<List<String>> head;
    private Row<List<String>> tail;

    //key: value
    HashMap<String, Integer> map = new HashMap<>(); //all keys mapping

    //value: row
    HashMap<Integer, List<String>> rowMap= new HashMap<>();



    /**
     * case 1:
     *  incr: get value by key from map, increase value and do put;
     *          a). use old value do delete from rowMap;
     *          b). use new value do add from rowMap;
     *  desc: get value by key from map, decrease value and do put;
     *          a). if value is zero, delete from rowMap;
     *          b). if value is not zero, delete from rowMap by old value;
     *                                    add into RowMap by new value;
     *  getMaxKey: get tail from LinkedRow;
     *  getMinKey: get head from LinkedRow;
     *
     */


    public class Row<E> {
        int value;
        Row<E> next;
        Row<E> prev;
    }

    /** Initialize your data structure here. */
    public AllOne() {
        this.head = null;
        this.tail = null;
    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int count = 0;
        if (map.containsKey(key)) {
            count = map.get(key);
        }
        map.put(key, count+1);
        removeFromRow(count, key);
        addIntoRow(count+1, key);
    }

    /**
     *
     * @param count
     * @param key
     */
    private void addIntoRow(int count, String key) {

        if (rowMap.containsKey(count)) {
            List<String> list = rowMap.get(count);
            list.add(key);
            rowMap.put(count, list);

        }
    }

    private void removeFromRow(int count, String key) {

    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (map.containsKey(key)) {
            int count = map.get(key);
            removeFromRow(count, key);
            if (1 == count) {
                map.remove(key);
            }
            else {
                map.put(key, count-1);
                addIntoRow(count-1, key);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {

        if (tail == null) {
            return null;
        }

        int no = tail.value;
        if (rowMap.containsKey(no)) {
            List<String> list = rowMap.get(no);
            if (list.size() > 1) {
                return list.get(0);
            }
        }

        return null;
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {

        if (head == null) {
            return null;
        }

        int no = head.value;
        if (rowMap.containsKey(no)) {
            List<String> list = rowMap.get(no);
            if (list.size() > 1) {
                return list.get(0);
            }
        }

        return null;
    }
}
