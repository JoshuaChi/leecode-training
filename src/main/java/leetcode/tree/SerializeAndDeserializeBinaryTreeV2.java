package leetcode.tree;

import java.util.Arrays;
import java.util.Deque;
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
public class SerializeAndDeserializeBinaryTreeV2 {

    private static final String spliter = ",";
    private static final String NN = "X";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
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

        SerializeAndDeserializeBinaryTreeV2 codec = new SerializeAndDeserializeBinaryTreeV2();
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
