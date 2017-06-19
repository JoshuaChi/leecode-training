package leetcode.array;

/**
 * Created by joshua.chi on 6/19/17.
 */
public class Dequeue {

    int[] items;

    int size = 0;
    int capacity;
    float loadFactor;

    public Dequeue(int n) {
        this.capacity = n;
        this.loadFactor = 0.75f;
        items = new int[this.capacity];
    }

    public Dequeue(int n, float loadFactor) {
        this.capacity = n;
        this.loadFactor = loadFactor;
        items = new int[this.capacity];
    }

    public boolean isFull() {
        return size >= (this.capacity * loadFactor); //10 * 0.75 = 7
    }

    public void increaseCapacity() {
        int[] newItems = new int[this.capacity * 2];
        System.arraycopy(items, 0, newItems, 0, items.length);
        items = newItems;
    }

    public void insertFront(int v) {
        if (isFull()) {
            increaseCapacity();
        }
        moveArray1UnitBack();
        items[0] = v;
        size++;
    }

    private void moveArray1UnitBack() {
        for (int i=size; i>0; i--) {
            items[i] = items[i-1];
        }
    }

    public void push(int v) {
        insertFront(v);
    }

    public void insertEnd(int v) {
        if (isFull()) {
            increaseCapacity();
        }
        items[size] = v;
        size++;
    }

    public int retrieveFirst() {
        return items[0];
    }

    public int pop() {
        int[] newItems = new int[size-1];
        int top = items[0];
        System.arraycopy(items, 1, newItems, 0, size-1);
        items = newItems;
        size--;
        return top;
    }

    public int retrieveLast() {
        return items[size-1];
    }

    public int removeLast() {
        int last = items[size-1];
        size--;
        return last;
    }


    public static void main(String[] args) {
        Dequeue dequeue = new Dequeue(3);
        dequeue.push(1);
        dequeue.push(2);
        dequeue.push(3);
        dequeue.push(4);

        int top = dequeue.pop(); //4,3,2,1
        System.out.println(top); //4
        //3,2,1

        dequeue.insertEnd(5);
        dequeue.insertEnd(6);
        dequeue.insertEnd(7);
        int last = dequeue.removeLast();
        System.out.println(last); //7

        top = dequeue.pop(); //3,2,1
        System.out.println(top); //3
    }

}
