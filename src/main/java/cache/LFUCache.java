package cache;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by Joshua on 6/18/17.
 */
public class LFUCache {
    private HashMap<String, Element> store = new HashMap<>();

    PriorityQueue<Element> maxHeap;



    public LFUCache() {
        maxHeap  = new PriorityQueue<>((o1, o2) -> o2.value < o1.value ? 1: -1);
    }

    public String getLastFrquencyItem() {
        Element e = maxHeap.peek();
        return e.key;
    }

    public void useItem(String item) {

        Element v = null;
        if (store.containsKey(item)) {
            v = store.get(item);

            if (maxHeap.contains(v)) {
                maxHeap.remove(v);
            }

            v.incr();
            store.put(item, v);
        }
        else {
            v = new Element(item, 1);
            store.put(item, v);
        }

        maxHeap.add(v);
    }


    public class Element {

        String key;
        int value;

        public Element(String k, int v) {
            key = k;
            value = v;
        }

        public void incr() {
            this.value++;
        }
    }

    public static void main(String[] args) {

        LFUCache lfuCache = new LFUCache();
        lfuCache.useItem("A");
        lfuCache.useItem("B");
        lfuCache.useItem("C");
        lfuCache.useItem("B");
        lfuCache.useItem("A");
        lfuCache.useItem("B");

        System.out.println(lfuCache.getLastFrquencyItem()); // C
    }
}
