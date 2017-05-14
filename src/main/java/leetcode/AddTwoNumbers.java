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

    public int length(ListNode l1) {
        int l = 0;
        while (l1 != null) {
            l++;
            l1 = l1.next;
        }
        return l;
    }

    public ListNode populate(ListNode l, int len) {
        if (len < 1) {
            return l;
        }
        ListNode pointer = null;
        ListNode head = null;
        while(l !=null) {
            if (pointer == null) {
                pointer = new ListNode(l.val);
                head = pointer;
            }
            else {
                pointer.next = new ListNode(l.val);
                pointer = pointer.next;
            }

            l = l.next;
        }
        ListNode n = createEmptyList(len);
        pointer.next = n;

        return head;
    }

    private ListNode createEmptyList(int len) {
        ListNode pointer = null;
        ListNode node = null;
        while (len > 0) {
            ListNode ele = new ListNode(0);
            if (node == null) {
                node = ele;
                pointer = node;
            } else {
                node.next = ele;
                node = node.next;
            }
            len--;
        }
        return pointer;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        int length1 = length(l1);
        int length2 = length(l2);
        if (length1 > length2) {
            l2 = populate(l2, length1 - length2);
        } else {
            l1 = populate(l1, length2 - length1);
        }
        ListNode l = null;
        ListNode first = null;

        int high = 0;
        while (l1 != null) {
            int n1 = l1.val;
            int n2 = l2.val;

            int n = n1 + n2;
            int v = (n + high) % 10;
            high = (high + n) / 10;

            if (l == null) {
                l = new ListNode(v);
                first = l;
            } else {
                l.next = new ListNode(v);
                l = l.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        if (high !=0) {
            l.next = new ListNode(high);
        }


        return first;
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

//        l10 = new ListNode(1);
//        l11 = new ListNode(8);
//        ListNode l12 = new ListNode(3);
//        l10.next = l11;
//        l11.next = l12;
//
//        l20 = new ListNode(7);
//        ListNode l21 = new ListNode(1);
////        ListNode l22 = new ListNode(4);
//        l20.next = l21;
////        l21.next = l22;
//
//        node = addTwoNumbers.addTwoNumbers(l10, l20);
//        while (node != null) {
//            System.out.println(node.val);
//            node = node.next;
//        }

//        ListNode l10 = new ListNode(5);
//
//        ListNode l20 = new ListNode(5);
//
//        ListNode node = addTwoNumbers.addTwoNumbers(l10, l20);
//        while (node != null) {
//            System.out.println(node.val);
//            node = node.next;
//        }
    }
}