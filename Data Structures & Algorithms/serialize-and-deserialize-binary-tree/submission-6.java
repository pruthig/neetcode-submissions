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

    public void sHelper(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append("1001").append("#");
            return;
        }
        sb.append(String.valueOf(node.val)).append("#");
        sHelper(node.left, sb);
        sHelper(node.right, sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sHelper(root, sb);
        return sb.toString();
        
    }
    public TreeNode dsHelper(String[] split, int[] idx) {
        ++idx[0];

        if(idx[0] >= split.length || split[idx[0]].equals("1001"))
            return null;
        int v = Integer.parseInt(split[idx[0]]);
        TreeNode node = new TreeNode(v);
        node.left = dsHelper(split, idx);
        node.right = dsHelper(split, idx);
        return node;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)
            return null;
        String[] splitted = data.split("#");
        int[] idx = {-1};
        return dsHelper(splitted, idx);
    }
}
