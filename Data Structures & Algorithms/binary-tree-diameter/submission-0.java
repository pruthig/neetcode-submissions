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
    int d = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        diameterOfBinaryTreeH(root);
        return d;
    }
        
    public int diameterOfBinaryTreeH(TreeNode root) {
        if(root == null)
            return 0;
        int mxl = diameterOfBinaryTreeH(root.left); //0 //
        int mxr = diameterOfBinaryTreeH(root.right); // // //
        d = Math.max(d, mxl+mxr);
        return 1+Math.max(mxl, mxr);
    }
}
