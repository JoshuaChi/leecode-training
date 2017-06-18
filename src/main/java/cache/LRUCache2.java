package cache;

import java.util.Map;

/**
 * Created by Joshua on 6/18/17.
 */
public class LRUCache2 {
    private int capacity;
    private Map<Integer, Integer> cache;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        this.cache = new java.util.LinkedHashMap<Integer, Integer> (capacity, 0.75f, true) {
            // 定义put后的移除规则，大于容量就删除eldest
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            return cache.get(key);
        } else
            return -1;
    }

    public void set(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args ) {

        LRUCache2 lruCache1 = new LRUCache2(3);
        lruCache1.set(1,2);
        lruCache1.set(2, 3);
        lruCache1.set(1, 5);
        lruCache1.set(4, 5);
        lruCache1.set(6, 7);
        System.out.println(lruCache1.get(6));
        System.out.println(lruCache1.get(1));
        lruCache1.set(1,2);
        lruCache1.set(2, 3);
        lruCache1.set(1, 5);
        lruCache1.set(4, 5);
        lruCache1.set(6, 7);
        System.out.println(lruCache1.get(6));
        System.out.println(lruCache1.get(1));

    }
}
