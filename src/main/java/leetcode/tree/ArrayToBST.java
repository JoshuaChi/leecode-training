package leetcode.tree;

import java.util.Arrays;

/**
 * Created by Joshua on 6/1/17.
 */
public class ArrayToBST {

    public class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
    public void soryArray(int[] ary) {
        Arrays.sort(ary);
    }

    public Node buildTreeFromAry(int[] ary, int start, int end) {
        soryArray(ary);
        if (start > end) {
            return null;
        }

        //find mid element between start and end
        int mid = start + (end-start)/2;
        Node node = new Node(ary[mid]);

        node.left = buildTreeFromAry(ary, start, mid-1);
        node.right = buildTreeFromAry(ary, mid+1, end);
        return node;
    }

    public static void main (String[] args) {
        int[] array = new int[]{4,3,8,5,2,1,9,6,7};
        ArrayToBST arrayToBST = new ArrayToBST();
        Node root = arrayToBST.buildTreeFromAry(array, 0, array.length-1);
        arrayToBST.printTree(root);

    }

    public void printTree(Node n) {

        if (n == null) {
            return;
        }

        System.out.print(n.data + " ");
        printTree(n.left);
        printTree(n.right);
    }
}
