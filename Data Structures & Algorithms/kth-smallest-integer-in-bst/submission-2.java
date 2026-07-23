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

    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.push(root);
        TreeNode cur = root.left;
        int kth = 0;
        while(!dq.isEmpty() || cur != null) {
            while(cur != null) {
                dq.push(cur);
                cur = cur.left;
            }
            TreeNode popped = dq.pop();
            ++kth;
            if(kth == k)
                return popped.val;
            cur = popped.right;
        }
        return dq.pop().val;
    }
}
