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
    public void rightSideViewHelper(TreeNode root, int level) {
        if(root == null)
            return;
        if(level == lst.size()) {
            lst.add(root.val);
        }
        rightSideViewHelper(root.right, level+1);
        rightSideViewHelper(root.left, level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return lst;
        rightSideViewHelper(root, 0);
        return lst;
    }
}
