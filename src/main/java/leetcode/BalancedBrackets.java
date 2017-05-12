package leetcode;

/**
 * Created by Joshua on 5/12/17.
 */
import java.util.Scanner;

public class BalancedBrackets {

    private class Stack<E> {

        Element<E> last;
        int length;

        class Element<E> {
            private E data;
            private Element prev;

            public Element(E d) {
                this.data = d;
                this.prev = null;
            }

            public void setPrev(Element prev) {
                this.prev = prev;
            }

            public Element getPrev() {
                return  this.prev;
            }

            public E getData() {
                return this.data;
            }
        }

        public Stack () {
            this.last = null;
        }

        public void push(E data) {

            Element newElement = new Element(data);

            if (last == null) {
                this.last = newElement;
            }
            else {
                Element currentLast = this.last;
                newElement.setPrev(currentLast);
                this.last = newElement;
            }
            length++;
        }

        public E pop() {
            if (this.last == null) {
                return null;
            }
            else {
                Element currentLast = this.last;
                this.last = currentLast.getPrev();

                length--;
                return (E) currentLast.getData();
            }
        }

        public int getLength() {
            return this.length;
        }
    }

    public boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();

        char[] brackets = expression.trim().toCharArray();

        boolean shouldContinuePop = false;
        for (int i=0; i< brackets.length; i++) {
            char pair = getPair(brackets[i]);
            switch (pair) {
                case '}':
                case ')':
                case ']':
                    if (shouldContinuePop == false) {
                        stack.push(pair);
                        shouldContinuePop = true;
                        break;
                    }
                default:
                    Character top = stack.pop();
                    if (top == null || top != Character.valueOf(brackets[i])) {
                        return false;
                    }
                    else {
                        if (stack.getLength() > 0) {
                            shouldContinuePop = true;
                        }
                    }
            }
        }
        return true;
    }

    private static char getPair(char a1) {

        switch (a1) {
            case '{':
                return '}';
            case '(':
                return ')';
            case '[':
                return ']';
        }
        return '-';

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BalancedBrackets balancedBrackets = new BalancedBrackets();
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (balancedBrackets.isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}

