package leetcode;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Joshua.Chi <joshua.chi@akqa.com>
 *
 * @author joshua.chi
 * @date 5/12/17
 */

public class Tribes<E> {
    HashMap<E, Element> head = new HashMap<E, Element>();

    public int count(E[] data) {
        final E key = data[0];
        if (head.containsKey(key)) {
            Element element = head.get(key);
            return element.countChildren(data, 1);
        } else {
            return 0;
        }

    }

    /**
     * Given a children array,
     * we will add the array into the tribe tree
     *
     * @param data
     */
    public void push(E[] data) {
        final E key = data[0];
        if (head.containsKey(key) == false) {
            final Element root = new Element(key);
            root.addChildren(data, 1);
            head.put(key, root);
        } else {
            Element root = head.get(key);
            if (data.length > 1) {
                root.incr();
                root.addChildren(data, 1);
            }
        }
    }

    public class Element<E> {
        private E data;
        private int count;
        HashMap<E, Element> children = new HashMap<E, Element>();

        public Element(E data) {
            this.data = data;
            this.count = 1;
        }

        public boolean hasChild(E d) {
            if (children.containsKey(d) == false) {
                return false;
            }
            return true;
        }

        public boolean hasChild() {
            if (children.isEmpty()) {
                return false;
            }
            return true;
        }
        public void incr() {
            this.count +=1;
        }

        /**
         * Given an element, if the child is not linked, we will create one;
         *
         * @param data
         */
        public void addChild(E data) {
            if (false == children.containsKey(data)) {
                children.put(data, new Element(data));
                count++;
            }
        }

        public void addChildren(E[] data, int i) {
            if (i >= data.length) {
                return;
            }

            if (false == children.containsKey(data[i])) {
                final Element<E> child = new Element<E>(data[i]);
                children.put(data[i], child);
                child.addChildren(data, i + 1);
            } else {
                Element child = children.get(data[i]);
                if (i+1 < data.length) {
                    child.incr();
                    child.addChildren(data, i + 1);
                }
            }
        }

        public int getCount() {
            return this.count;
        }

        public int countChildren(E[] data, int i) {
            if (this.count < 1) {
                return 0;
            }
            if (i >= data.length) {
                return this.count;
            }

            final E key = data[i];
            if (children.containsKey(key)) {
                Element child = children.get(key);
                return child.countChildren(data, i + 1);
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Tribes<Character> tribe = new Tribes();
        int n = in.nextInt();
        for (int a0 = 0; a0 < n; a0++) {
            String op = in.next();
            String contact = in.next();
            char[] array = contact.toCharArray();
            Character[] cs = new Character[array.length];
            for (int i=0; i< array.length; i++) {
                cs[i] = Character.valueOf(array[i]);
            }
            if (op.equals("add")) {
                tribe.push(cs);
            }
            else if (op.equals("find")) {
                System.out.println(tribe.count(cs));

            }
        }
    }
}
