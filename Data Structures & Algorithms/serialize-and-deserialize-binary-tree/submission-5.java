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

    public void shelper(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("1001").append("#");
            return;
        }
        sb.append(root.val).append("#");
        shelper(root.left, sb);
        shelper(root.right, sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        shelper(root, sb);
        return sb.toString();
    }

    public TreeNode dshelper(String[] splitted, int[] i) {
        ++i[0];
        if(i[0] >= splitted.length || splitted[i[0]].equals("1001")) {
            return null;
        }
        int v = Integer.parseInt(splitted[i[0]]);
        TreeNode tn = new TreeNode(v);
        tn.left = dshelper(splitted, i);
        tn.right = dshelper(splitted, i);
        return tn;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] splitted = data.split("#");
        int[] i = {-1};
        TreeNode t = dshelper(splitted, i);
        return t;
    }
}
