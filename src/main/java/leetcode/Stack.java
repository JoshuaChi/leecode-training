package leetcode;

/**
 * Created by Joshua.Chi <joshua.chi@akqa.com>
 *
 * @author joshua.chi
 * @date 5/11/17
 */
public class Stack<E> {
    private Element next;
    private int length;

    public Stack(){
        next = null;
        length = 0;
    }

    private class Element<E> {
        private E data;
        private Element<E> prev;
        public Element(E d) {
            this.data = d;
            this.prev = null;
        }

        public void setPrev(Element prev) {
            this.prev = prev;
        }
    }

    public void push(E data) {
        Element e = new Element(data);
        if (null == this.next) {
            this.next = e;
        }
        else {
            Element oldNext = this.next;
            this.next = e;
            e.setPrev(oldNext);
        }
        this.length++;
    }

    public E peak() {
        if (0 == this.length) {
            return null;
        }

        Element last = this.next;
        if (1 == this.length ) {
            this.next = null;
        }
        else {
            this.next = last.prev;
        }
        this.length--;

        return (E) last.data;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peak());//should be 4
        System.out.println(stack.peak());//should be 3
        System.out.println(stack.peak());//should be 2
        System.out.println(stack.peak());//should be 1
        System.out.println(stack.peak());//should be null
    }

}
