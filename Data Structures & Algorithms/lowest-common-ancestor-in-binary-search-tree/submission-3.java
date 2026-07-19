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

    // int lex = Integer.MAX_VALUE;
    // int rex = Integer.MIN_VALUE;
    public TreeNode lcmHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        System.out.println("p is: " + p.val);
        System.out.println("q val is: " + q.val);
        System.out.println("root is: " + root.val);
        if(p.val == root.val || q.val == root.val)
            return root;
        if(p.val < root.val && q.val > root.val)
            return root;
        else if(p.val < root.val && q.val < root.val)
            return lcmHelper(root.left, p, q);
        else
            return lcmHelper(root.right, p, q);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode l, r;
        if(root == null)
            return null;
        if(p.val < q.val) {
            l = p;
            r = q;
        } else {
            l = q;
            r = p;
        }
        return lcmHelper(root, l, r);
    }
}
