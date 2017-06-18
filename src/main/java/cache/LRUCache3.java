package cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joshua on 6/18/17.
 */
public class LRUCache3 {
    private int capacity;
    private Map<Integer, Node> cache;
    private Node first;
    private Node last;
    private int size=0;

    public LRUCache3(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        first = null;
        last = null;
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            Node n = cache.get(key);
            return n.data;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (isFull()) {
            reset();
            size = capacity -1;
        }

        Node node = null;
        if(cache.containsKey(key)) {
            node = cache.get(key);
            if (node == first) {
                first = node.next;
            }
            if (node == last) {
                last = node.prev;
            }
            Node previousNode = node.prev;
            Node nextNode = node.next;
            if (previousNode != null) {
                previousNode.next = nextNode;
            }
            if (nextNode != null) {
                nextNode.prev = previousNode;
            }

            node.next = null;
            node.data = value;
        } else {
            node = new Node(key, value);
            size++;
        }
        cache.put(key, node);
        if(first == null) {
            first = node;
            last = node;
        }
        else {
            last.next = node;
            last = node;
        }
    }

    private void reset() {

        if (first != null) {
            cache.remove(first.key);

            Node t = first.next;
            first = t;
            if (t == last) {
                last = null;
            }
        }
    }

    public boolean isFull() {
        return size >= capacity;
    }

    public class Node {
        int key;
        int data;
        Node next;
        Node prev;

        public Node(int k, int v) {
            this.key = k;
            this.data = v;
            this.next = null;
            this.prev = null;
        }
    }
    public static void main(String[] args ) {

        LRUCache3 lruCache1 = new LRUCache3(3);
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
