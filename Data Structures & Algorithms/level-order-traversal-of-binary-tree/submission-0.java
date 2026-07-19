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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null)
            return res;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.addLast(root);
        int count = dq.size();
        while(!dq.isEmpty()) {
            int i=0;
            List<Integer> localList = new ArrayList<>();
            while(i<count) {
                TreeNode removed = dq.peekFirst(); dq.removeFirst();
                localList.add(removed.val);
                if(removed.left != null)
                    dq.addLast(removed.left);
                if(removed.right != null)
                    dq.addLast(removed.right);
                ++i;
            }
            res.add(localList);
            count = dq.size();
        }
        return res;
    }
}
