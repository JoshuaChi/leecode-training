package leetcode.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class SerializeAndDeserializeBinaryTreeV1 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        int h = height(root);
        ArrayList<String> list = new ArrayList<>();
        __serialize(root, list, h);

        return String.join(",", list);
    }

    public String val(TreeNode node, int height) {
        if (height <= 0) {
            return "";
        }
        return (node == null) ? "X" : String.valueOf(node.val);
    }

    public void __serialize(TreeNode node, ArrayList<String> list, int height) {
        if (height <= 0) {
            return;
        }
        if (node == null) {
            list.add("X");
        } else {
            list.add(String.valueOf(node.val));
        }


        __serialize(node == null ? null : node.left, list, height - 1);
        __serialize(node == null ? null : node.right, list, height - 1);
    }

    public int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left != null && node.right != null) {
            return 1 + Math.max(height(node.left), height(node.right));
        }
        if (node.right != null) {
            return 1 + height(node.right);
        }
        if (node.left != null) {
            return 1 + height(node.left);
        }
        return 1;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
//        System.out.println(" >> " + data + " <<");
        if (data.length() < 1) {
            return null;
        }
        String[] ary = data.split(",");
        LinkedList<String> list = new LinkedList<>();
        list.addAll(Arrays.asList(ary));
        if (ary.length < 1 || ary[0].equals("X")) {
            return null;
        }


        return __deserialize(list);

    }


    public TreeNode __deserialize(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String v = list.pop();
        if (v.equals("X")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(v));
        node.left = __deserialize(list);
        node.right = __deserialize(list);

        return node;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;

        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);
        left.left = left2;
        left.right = right2;

        SerializeAndDeserializeBinaryTreeV1 codec = new SerializeAndDeserializeBinaryTreeV1();
        String serializeString = codec.serialize(root);
        System.out.println("1:");
        System.out.println(serializeString);
        TreeNode n = codec.deserialize(serializeString);
        System.out.println("2:");
        codec.printTree(n);
    }

    public void printTree(TreeNode n) {

        if (n == null) {
            return;
        }

        System.out.print(n.val + " ");
        printTree(n.left);
        printTree(n.right);
    }

}

// Your Codec object will be instantiated and called as such:
