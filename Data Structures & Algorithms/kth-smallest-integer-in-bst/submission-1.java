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
    int kth = 0;
    public TreeNode kthSmallestHelper(TreeNode root, int k) {
        if(root == null)
            return null;
        TreeNode t1 = kthSmallestHelper(root.left, k);
        ++kth;
        if(kth == k) {
            return root;
        }
        TreeNode t2 = kthSmallestHelper(root.right, k);
        return (t1!=null)?t1:t2;
    }
    public int kthSmallest(TreeNode root, int k) {
        return kthSmallestHelper(root, k).val;
    }
}
