package leetcode;

/**
 * Created by Joshua.Chi <joshua.chi@akqa.com>
 *
 * @author joshua.chi
 * @date 5/11/17
 */
public class Queue<E> {
    private Element head;
    private Element tail;
    private int length;

    public Queue(){
        head = null;
        tail = null;
        length = 0;
    }

    private class Element<E> {
        private E data;
        private Element<E> next;
        public Element(E d) {
            this.data = d;
            this.next = null;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    public void push(E data) {
        Element e = new Element(data);
        if (null == this.head) {
            this.head = e;
            this.tail = e;
        }
        else {
            Element oldTail = this.tail;
            this.tail = e;
            oldTail.setNext(e);
        }
        this.length++;
    }

    public E peak() {
        if (0 == this.length) {
            return null;
        }

        Element head = this.head;
        if (1 == this.length ) {
            this.head = null;
            this.tail = null;
        }
        else {
            this.head = head.next;
            this.head.setNext(null);
        }
        this.length--;

        return (E) head.data;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.peak());//should be 1
        System.out.println(queue.peak());//should be 2
        System.out.println(queue.peak());//should be 3
        System.out.println(queue.peak());//should be 4
        System.out.println(queue.peak());//should be null
    }

}
