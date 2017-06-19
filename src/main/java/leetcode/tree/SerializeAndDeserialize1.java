package leetcode.tree;

import java.util.LinkedList;

/**
 * Created by Joshua on 6/19/17.
 * LC:297
 */

class SerializeAndDeserialize1 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        if (root == null) {
            return buffer.append("]").toString();
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        buffer.append(root.val);

        while (false == queue.isEmpty()) {
            TreeNode node = queue.removeFirst();

            if (node.left == null) {
                buffer.append(",").append("null");
            }
            else {
                buffer.append(",").append(node.left.val);
                queue.addLast(node.left);
            }

            if (node.right == null) {
                buffer.append(",").append("null");
            }
            else {
                buffer.append(",").append(node.right.val);
                queue.addLast(node.right);
            }
        }

        return buffer.append("]").toString();
    }


    public TreeNode deserialize(String data) {
        if (data.length() < 3) {
            return null;
        }
        data = data.substring(1, data.length()-1);

        String[] ary = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(ary[0]));
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);

        int index = 1;
        while (queue.isEmpty() == false) {
            TreeNode node = queue.removeFirst();

            if (index < ary.length && ary[index].equals("null") == false) {
                int next = Integer.parseInt(ary[index]);
                node.left = new TreeNode(next);
                queue.addLast(node.left);
            }
            index++;


            if (index < ary.length && ary[index].equals("null") == false) {
                int next = Integer.parseInt(ary[index]);
                node.right = new TreeNode(next);
                queue.addLast(node.right);
            }
            index++;

        }
        return root;
    }
}