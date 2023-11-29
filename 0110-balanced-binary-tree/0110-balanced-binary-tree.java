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
    public int helper(TreeNode root,boolean[] ans)
    {
        if(root==null)
            return 0;
        int l=helper(root.left,ans);
        int r=helper(root.right,ans);
        if(Math.abs(l-r)>1)
            ans[0]=false;
        return Math.max(l,r)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null)
           return true;
        boolean ans[]=new boolean[1];
        ans[0]=true;
        helper(root,ans);
        return ans[0];
    }
}