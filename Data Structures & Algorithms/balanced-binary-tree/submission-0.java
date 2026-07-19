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
    public boolean heightBalanced = true;
    public int isBalancedHelper(TreeNode root) {
        if(root == null)
            return 0;
        int lh = isBalancedHelper(root.left);
        int rh = isBalancedHelper(root.right);
        if(Math.abs(lh-rh)>1) {
            heightBalanced = false;
        }
        return 1 + Math.max(lh, rh);
        
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        isBalancedHelper(root);
        return heightBalanced;
    }
}
