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

    public boolean isValidHelper(TreeNode root, int a, int b) {
        if(root == null)
            return true;
        if(root.val <= a || root.val >= b)
            return false;
        boolean lt = isValidHelper(root.left, a, root.val);
        boolean rt = isValidHelper(root.right, root.val, b);
        return lt && rt;
    }
    public boolean isValidBST(TreeNode root) {
        return isValidHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
