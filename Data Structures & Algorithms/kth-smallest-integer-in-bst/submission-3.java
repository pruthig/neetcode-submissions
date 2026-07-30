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
    int g = 0;
    public TreeNode kthSmallestHelper(TreeNode root) {
        if(root == null)
            return null;
        TreeNode l = kthSmallestHelper(root.left);
        --g;
        if(g == 0)
            return root;
        TreeNode r = null;
        if(l == null) {
            r = kthSmallestHelper(root.right);
        }
        return (l!=null)?l:r;
    }
    public int kthSmallest(TreeNode root, int k) {
        g = k;
        TreeNode t =  kthSmallestHelper(root);
        return t.val;
    }
}
