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

class Solution {
    public void invertTreeHelper(TreeNode t) {
        if(t == null)
            return;
        invertTreeHelper(t.left);
        invertTreeHelper(t.right);
        TreeNode tmp = t.left;
        t.left = t.right;
        t.right = tmp;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        invertTreeHelper(root);
        return root;
    }
}
