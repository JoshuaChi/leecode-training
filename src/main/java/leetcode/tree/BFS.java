package leetcode.tree;

import java.util.LinkedList;

/**
 * Created by Joshua on 6/3/17.
 */
public class BFS {

    public void BFS(LinkedList<TreeNode> list) {
        if (list == null || list.isEmpty()) {
            return;
        }

        while (false == list.isEmpty()) {
            TreeNode node = list.poll();
            System.out.println(node.val);
            if (node.left != null) {
                list.addLast(node.left);
            }
            if (node.right != null) {
                list.addLast(node.right);
            }
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

        SerializeAndDeserializeBinaryTreeV1 codec = new SerializeAndDeserializeBinaryTreeV1();
        String serializeString = codec.serialize(root);
        System.out.println("1:");
        System.out.println(serializeString);
        TreeNode n = codec.deserialize(serializeString);
        System.out.println("2:");
        codec.printTree(n);
    }
}
