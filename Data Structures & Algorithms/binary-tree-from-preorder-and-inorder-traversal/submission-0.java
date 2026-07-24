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
    TreeNode head = null;
    int pindex = -1;
    public int findIndex(int number, int[] inorder) {
        for(int i=0;i<inorder.length;++i) {
            if(inorder[i] == number)
                return i;
        }
        return -1;
    }
    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int i, int j) {
        if(i>j)
            return null;
        int rootValue = preorder[++pindex];
        TreeNode cur = new TreeNode(rootValue);
        int idx = findIndex(rootValue, inorder);
        cur.left = buildTreeHelper(preorder, inorder, i, idx-1);
        cur.right = buildTreeHelper(preorder, inorder, idx+1, j);
        return cur;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        return buildTreeHelper(preorder, inorder, 0, inorder.length-1);
    }
}
