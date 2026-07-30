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
    // number, index
    Map<Integer, Integer> map = new HashMap<>();
    int pre = -1;
    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int i, int j) {
        if(i>j)
            return null;
        TreeNode tr = new TreeNode(preorder[++pre]);
        if(i==j)
            return tr;
        int idx = map.get(preorder[pre]);
        tr.left = buildTreeHelper(preorder, inorder,i, idx-1);
        tr.right = buildTreeHelper(preorder, inorder,idx+1, j);
        return tr;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;++i) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, inorder, 0, inorder.length-1);
    }
}
