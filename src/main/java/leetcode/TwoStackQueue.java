package leetcode;

import java.util.*;

/**
 * Created by Joshua.Chi <joshua.chi@akqa.com>
 *
 * @author joshua.chi
 * @date 5/12/17
 */
public class TwoStackQueue<E> {
    Stack<E> newItemOnTop; //E1->E2->E3;
    Stack<E> oldItemOnTop; //E3->E2->E1;

    public TwoStackQueue() {
        this.newItemOnTop = new Stack();
        this.oldItemOnTop = new Stack();
    }


    public E peek() {
        if (oldItemOnTop.getLength() < 1) {
            while(newItemOnTop.getLength() > 0) {
                oldItemOnTop.push(newItemOnTop.pop());
            }
        }
        return oldItemOnTop.peak();
    }

    public E dequeue() {
        if (oldItemOnTop.getLength() < 1) {
            while(newItemOnTop.getLength() > 0) {
                oldItemOnTop.push(newItemOnTop.pop());
            }
        }

        return oldItemOnTop.pop();
    }

    public void enqueue(E i) {
        newItemOnTop.push(i);
    }

    public class Stack<E> {
        private Element last;
        private int length;

        public class Element<E> {
            private E data;
            private Element<E> prev;
            public Element(E data) {
                this.data = data;
                this.prev = null;
            }
            public void setPrev(Element prev) {
                this.prev = prev;
            }
            public Element getPrev() {
                return this.prev;
            }

            public E getData() {
                return data;
            }
        }

        public Stack() {
            this.last = null;
        }

        public void push(E data) {
            final Element element = new Element(data);
            if (last == null) {
                last = element;
            }
            else {
                Element current = this.last;
                element.setPrev(current);
                this.last = element;
            }
            length++;
        }

        public E pop() {
            if (last == null) {
                return null;
            } else {
                Element current = this.last;
                this.last = current.getPrev();
                length--;
                return (E) current.getData();
            }
        }

        public int getLength() {
            return this.length;
        }

        public E peak() {
            if (last == null) {
                return null;
            } else {
                Element current = this.last;
                return (E) current.getData();
            }
        }
    }

    public static void main(String[] args) {
        TwoStackQueue<Integer> queue = new TwoStackQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

}
