package leetcode.tree;

/**
 * Created by joshua.chi on 5/25/17.
 */
public class SelfBalancingTree {

    /**
     * Assume it is a BST
     *
     * @param root
     * @param val
     * @return
     */
    static Node insert(Node root, int val) {
        Node node = new Node();
        node.val = val;

        Node cursor = root;
        Node firstParentCursor = root;
        Node secondParentCursor = null;
        boolean isLeft = false;
        int rebalanceFactor = 0;//0: no need ; 1: right; -1:left;
        //1. insert
        while (true) {
            //insert it into left
            if (cursor.val > val) {
                if (cursor.left != null) {
                    firstParentCursor = cursor;
                    cursor.ht += 1;

                    //2. checkIfNeedRelance
                    if (needRebalance(cursor)) {
                        rebalanceFactor = -1;
                    }

                    cursor = cursor.left;
                    secondParentCursor = cursor;
                } else {
                    cursor.left = node;
                    isLeft = true;
                    cursor.ht += 1;
                    break;
                }

            } else {
                if (cursor.right != null) {
                    firstParentCursor = cursor;

                    cursor.ht -= 1;
                    //2. checkIfNeedRelance
                    if (needRebalance(cursor)) {
                        rebalanceFactor = 1;
                    }

                    cursor = cursor.right;
                    secondParentCursor = cursor;
                } else {
                    cursor.right = node;
                    isLeft = false;
                    cursor.ht -= 1;
                    break;
                }

            }
        }

        //3. balance
        cursor = root;

        Node prev = null;
        if (isLeft == false) {
            if (rebalanceFactor == -1) { // Left Right case

                while (cursor != null && cursor != firstParentCursor) {
                    cursor.ht -= 1;
                    prev = cursor;
                    cursor = cursor.right;
                }
                if (prev == null) {
                    root = buildSubTree(firstParentCursor, secondParentCursor, node, 1);
                }
                else {
                    prev.right = buildSubTree(firstParentCursor, secondParentCursor, node, 1);
                }

            } else if (rebalanceFactor == 1) { //Right right case
                while (cursor != null && cursor != firstParentCursor) {
                    cursor.ht += 1;
                    prev = cursor;
                    cursor = cursor.right;
                }

                if (prev == null) {
                    root = buildSubTree(firstParentCursor, secondParentCursor, node, -2);
                }
                else {
                    prev.right = buildSubTree(firstParentCursor, secondParentCursor, node, -2);
                }
            }
        } else {
            if (rebalanceFactor == -1) { // Left Left case
                while (cursor != null && cursor != firstParentCursor) {
                    cursor.ht -= 1;
                    prev = cursor;
                    cursor = cursor.left;
                }

                if (prev == null) {
                    root = buildSubTree(firstParentCursor, secondParentCursor, node, -1);
                }
                else {
                    prev.left = buildSubTree(firstParentCursor, secondParentCursor, node, -1);
                }
            } else if (rebalanceFactor == 1) { //Right Left case
                while (cursor != null && cursor != firstParentCursor) {
                    cursor.ht += 1;
                    prev = cursor;
                    cursor = cursor.left;
                }
                if (prev == null) {
                    root = buildSubTree(firstParentCursor, secondParentCursor, node, 2);
                }
                else {
                    prev.left = buildSubTree(firstParentCursor, secondParentCursor, node, 2);
                }
            }
        }
        return root;

    }

    public static boolean needRebalance(Node n) {
        if (n.ht > 1 || n.ht < -1) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param first
     * @param second
     * @param leaf
     * @param direction
     *  1: left right
     *  -1: left left;
     *  2: right left;
     *  -2:right right
     * @return
     */
    public static Node buildSubTree(Node first, Node second, Node leaf, int direction) {

        Node root = null;
        switch (direction) {
            case 1:
                root = leaf;
                root.left = second;
                root.right = first;

                reset(second);
                reset(first);
                break;
            case -1:
                root = second;
                root.left = leaf;
                root.right = first;

                reset(leaf);
                reset(first);
                break;
            case 2:
                root = leaf;
                root.left = first;
                root.right = second;

                reset(second);
                reset(first);
                break;
            case -2:
                root = second;
                root.left = first;
                root.right = leaf;

                reset(leaf);
                reset(first);
                break;
        }
        root.ht = 0;
        return root;
    }

    public static void reset(Node n) {
        n.ht = 0;
        n.left = null;
        n.right = null;
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.val = 3;

        root = insert(root, 2);
        print(root);
        System.out.println("");
        root = insert(root, 4);
        print(root);
        System.out.println("");
        root = insert(root, 5);
        print(root);
        System.out.println("");
        root = insert(root, 6);
        print(root);
        System.out.println("");

    }

    public static void print(Node tree) {

        if (tree == null) {
            return;
        }

        System.out.print(tree.val + "(BF=" + tree.ht +") ");
        print(tree.left);
        print(tree.right);



    }
}
