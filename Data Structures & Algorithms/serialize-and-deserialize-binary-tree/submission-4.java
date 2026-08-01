/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    public void serializeHelper(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("1001").append("#");
            return;
        }
        sb.append(String.valueOf(root.val)).append("#");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    public TreeNode deserializeHelper(String[] data, int[] cursor) {
        if(data[cursor[0]].equals("1001")) {
            cursor[0]++;
            return null;
        }
        String str = data[cursor[0]++];
        TreeNode node = new TreeNode(Integer.parseInt(str));
        node.left = deserializeHelper(data, cursor);
        node.right = deserializeHelper(data, cursor);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] cursor = {0};
        String[] splitted = data.split("#");
        return deserializeHelper(splitted, cursor);
    }
}
