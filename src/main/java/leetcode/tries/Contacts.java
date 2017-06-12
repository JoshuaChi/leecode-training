package leetcode.tries;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Joshua on 6/11/17.
 */
public class Contacts {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Tries t = new Tries();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String op = in.next();
            String contact = in.next();
            if (op.equals("add")) {
                t.add(contact.toCharArray());
            }
            else {
                int c = t.find(contact.toCharArray());
                System.out.println(c);
            }

        }
    }

    public static class Tries {
        Node head;

        public Tries() {
            head = new Node(' ');
        }

        public class Node {
            char data;
            List<Node> next;
            int count;
            public Node(char c) {
                this.data = c;
                this.next = null;
                this.count = 1;
            }

            public void incr() {
                this.count++;
            }
        }

        public void add(char[] cs) {
            Node cursor = head;
            int count = 0;
            while (count < cs.length) {
                List<Node> next = cursor.next;
                boolean found = false;
                if (next != null) {
                    for (Node n: next) {
                        if (n.data == cs[count]) {
                            found = true;
                            cursor = n;
                            n.incr();
                        }
                    }
                }
                else {
                    next = new ArrayList<>();
                    cursor.next = next;
                }
                if (false == found) {
                    Node n = new Node(cs[count]);
                    next.add(n);
                    cursor.next = next;
                    cursor = n;
                }
                count ++;
            }
        }

        public int find(char[] cs) {
            Node cursor = head;
            int count = 0;
            while (count < cs.length) {
                List<Node> next = cursor.next;
                boolean found = false;
                if (next != null) {
                    for (Node n: next) {
                        if (n.data == cs[count]) {
                            found = true;
                            cursor = n;
                        }
                    }
                }
                if (false == found) {
                    return 0;
                }
                count ++;
            }
            return cursor.count;

        }
    }
}
