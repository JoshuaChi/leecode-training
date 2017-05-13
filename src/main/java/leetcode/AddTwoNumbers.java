package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class AddTwoNumbers {
    public class Stack {
        private Element last;
        private int length;

        public Stack() {
            this.last = null;
            this.length = 0;
        }

        public class Element {
            private int data;
            private Element prev;

            public Element(int d) {
                this.data = d;
                this.prev = null;
            }

            public void setPrev(Element prev) {
                this.prev = prev;
            }

            public Element getPrev() {
                return this.prev;
            }

            public int getData() {
                return this.data;
            }
        }

        public void push(int d) {
            Element e = new Element(d);
            if (this.last == null) {
                this.last = e;
            } else {
                Element current = this.last;
                e.setPrev(current);
                this.last = e;
            }
            this.length++;
        }

        public int pop() {
            if (this.last == null) {
                return -1;
            } else {
                Element current = this.last;
                this.last = current.getPrev();
                this.length--;
                return current.getData();
            }
        }

        public int getLength() {
            return this.length;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //step1, create two stacks with value from l1 and l2
        Stack stack1 = transferFromListNode(l1);
        Stack stack2 = transferFromListNode(l2);
        if (stack1.getLength() > stack2.getLength()) {
            populateStack(stack2, stack1.getLength() - stack2.getLength());
        } else {
            populateStack(stack1, stack2.getLength() - stack1.getLength());
        }

        //step2, create third stack with calculate value
        Stack stack = calculate(inverseStack(stack1), inverseStack(stack2));
        //step3: create a new listNode from third stack
        return transferFromStack(inverseStack(stack));

    }

    public ListNode transferFromStack(Stack stack) {
        ListNode current = null;
        ListNode first = null;
        while (stack.getLength() > 0) {
            int num = stack.pop();
            if (null != current) {
                ListNode node = new ListNode(num);
                current.next = node;
                current = current.next;
            } else {
                current = new ListNode(num);
                first = current;

            }
        }
        return first;

    }

    public Stack transferFromListNode(ListNode l) {
        Stack stack = new Stack();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }

    public void populateStack(Stack s, int length) {
        for (int i = 0; i < length; i++) {
            s.push(0);
        }
    }

    public Stack calculate(Stack s1, Stack s2) {
        Stack stack = new Stack();

        int tmp = 0;
        while (s2.getLength() > 0) {
            int number1 = s2.pop();
            int number2 = s1.pop();
            int lowNumber = (tmp + number1 + number2) % 10;
            tmp = (tmp + (number1 + number2)) / 10;
            stack.push(lowNumber);
        }
        if (tmp > 0) {
            stack.push(tmp);
        }
        return stack;

    }

    public Stack inverseStack(Stack stack) {
        Stack newStack = new Stack();
        while (stack.getLength() > 0) {
            int num = stack.pop();
            newStack.push(num);
        }
        return newStack;
    }

    public static void main(String[] args) {

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l10 = new ListNode(9);
        ListNode l11 = new ListNode(8);
        l10.next = l11;

        ListNode l20 = new ListNode(1);

        ListNode node = addTwoNumbers.addTwoNumbers(l10, l20);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

        l10 = new ListNode(2);
        l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        l10.next = l11;
        l11.next = l12;

        l20 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);
        l20.next = l21;
        l21.next = l22;

        node = addTwoNumbers.addTwoNumbers(l10, l20);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}