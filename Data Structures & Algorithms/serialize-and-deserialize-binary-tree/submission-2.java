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
    //String[] ser = new String[Integer.MAX_VALUE];
    List<String> list = new ArrayList<>();
    int pos = 0;
    // Encodes a tree to a single string.
    public void serializeHelper(StringBuilder sb, TreeNode root, int idx) {
        if(root == null) {
            sb.append("1001#");
            return;
        }
        sb.append(String.valueOf(root.val)).append("#");
        serializeHelper(sb, root.left, 2*idx+1);
        serializeHelper(sb, root.right, 2*idx+2);
    }
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        serializeHelper(sb, root, 0);
        return sb.toString();
    }

    public TreeNode dsHelper(String[] data) {
        String token = data[pos++];
        if(token.equals("1001") || token.equals(""))
            return null;
        TreeNode tn = new TreeNode(Integer.parseInt(token));
        tn.left = dsHelper(data);
        tn.right = dsHelper(data);
        return tn;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String d) {
        if(d == null)
            return null;
        String[] res = d.split("#");
        return dsHelper(res);
    }
}
