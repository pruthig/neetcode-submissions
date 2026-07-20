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
    int nodes = 0;
    
    public void goodNodesHelper(TreeNode root, int mxtillnow) {
        if(root == null)
            return;
        int till = mxtillnow;
        if(root.val >= mxtillnow) {
            ++nodes;
            till = root.val;
        }
        goodNodesHelper(root.left, till);
        goodNodesHelper(root.right, till);
    }
    public int goodNodes(TreeNode root) {
        int mxtillnow = Integer.MIN_VALUE;
        goodNodesHelper(root, mxtillnow);
        return nodes;
    }
}
