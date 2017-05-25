package leetcode.tree;

/**
 * Created by joshua.chi on 5/25/17.
 */
public class Node {
    int val;
    int ht;
    Node left;
    Node right;

    public Node(int v) {
        this.val = v;
        this.ht = 0;
        this.left = null;
        this.right = null;
    }
    public Node() {

    }

    public void decreaseHeight() {
        this.ht --;
    }

    public void increaseHeight() {
        this.ht ++;
    }

    public boolean hasNextLevel() {
        if (left == null && right == null) {
            return false;
        }
        return true;
    }
}
