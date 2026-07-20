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
    List<Integer> lst = new ArrayList<>();
    int mxLevel = 0;
    public void rightSideViewHelper(TreeNode root, int level) {
        if(root == null)
            return;
        if(level > mxLevel) {
            lst.add(root.val);
            mxLevel = level;
        }
        rightSideViewHelper(root.right, level+1);
        rightSideViewHelper(root.left, level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return lst;
        rightSideViewHelper(root, 1);
        return lst;
    }
}
