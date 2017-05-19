package leetcode.others;

import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Created by Joshua on 5/18/17.
 */
public class LinkedListCross {


    public boolean hasCross(LinkedList<Node> l1, LinkedList<Node> l2, Hashtable<Node, Node> table) {
        if (l1.size() < 0 || l2.size() <0) {
            return false;
        }
        Node n1 = l1.pop();
        table.put(n1, n1.next);

        Node n2 = l2.pop();
        if(table.containsKey(n2)) {
            return true;
        }
        return hasCross(l1, l2, table);
    }
}
