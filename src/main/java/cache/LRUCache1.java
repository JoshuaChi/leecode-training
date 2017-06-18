package cache;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 The task is to design and implement methods of an LRU cache. The class has two methods get and set which are defined as follows.
 get(x)   : Gets the value of the key x if the key exists in the cache otherwise returns -1
 set(x,y) : inserts the value if the key x is not already present. If the cache reaches its capacity it should invalidate the least recently used item before inserting the new item.
 In the constructor of the class the size of the cache should be intitialized.
 */
public class LRUCache1 {
    private int capacity;

    private LinkedHashMap<Integer, Integer> cacheMap;

    public LRUCache1(int c) {
        this.capacity = c;
        cacheMap = new LinkedHashMap(c, (float) 0.75, true);
//        this.cacheMap = new java.util.LinkedHashMap<Integer, Integer> (capacity, 0.75f, true) {
//            // 定义put后的移除规则，大于容量就删除eldest
//            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//                return size() > capacity;
//            }
//        };
    }

    public Integer get(Integer key) {
        if (cacheMap.containsKey(key)) {
            return cacheMap.get(key);
        }
        return -1;
    }

    public void set(Integer key, Integer value) {
        if (isFull()) {
            removeLeastFrequentlyUsed();
        }
        cacheMap.put(key, value);
    }

    private boolean isFull() {
        return cacheMap.size() >= capacity;
    }

    private void removeLeastFrequentlyUsed() {
        Iterator i = cacheMap.entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry<Integer, Integer> e =
                    (Map.Entry<Integer, Integer>) i.next();
            cacheMap.remove(e.getKey());
            break;
        }
    }

    private class Element {
        String key;
        int priority;

        public Element(String key, int priority) {
            this.key = key;
            this.priority = priority;
        }

        public void incr () {
            this.priority++;
        }
    }

    public static void main(String[] args ) {

        LRUCache1 lruCache1 = new LRUCache1(3);
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
