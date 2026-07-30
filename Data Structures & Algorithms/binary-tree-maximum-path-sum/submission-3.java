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
    int mx = Integer.MIN_VALUE;
    public int maxPathSumHelper(TreeNode root) {
        if(root == null)
            return 0;
        int l = maxPathSumHelper(root.left);
        l = Math.max(0, l);
        int r = maxPathSumHelper(root.right);
        r = Math.max(0, r);
        int d = root.val + l + r;
        mx = Math.max(mx, d);
        return Math.max(l, r) + root.val;
    }
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return mx;
    }
}
