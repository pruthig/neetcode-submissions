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
    public boolean isSameTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return true;
        else if((t1 != null && t2 == null) || (t1 == null && t2 != null))
            return false;
        else
            return (t1.val == t2.val && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)
            return true;
        else if((root != null && subRoot == null) || (root == null && subRoot != null))
            return false;
        if(root.val == subRoot.val) {
            boolean val1 = isSameTree(root, subRoot);
            if(val1 == true)
                return val1;
        }
        boolean v1 = isSubtree(root.left, subRoot);
        boolean v2 = isSubtree(root.right, subRoot);
        return v1 || v2;
    }
}
