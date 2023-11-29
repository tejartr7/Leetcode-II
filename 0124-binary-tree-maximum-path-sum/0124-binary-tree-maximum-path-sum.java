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
    int maxi=0;
    public int helper(TreeNode root)
    {
        if(root==null)
            return 0;
        int l=Math.max(helper(root.left),0);
        int r=Math.max(helper(root.right),0);
        maxi=Math.max(maxi,l+r+root.val);
        return Math.max(l,r)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        maxi=Integer.MIN_VALUE;
        helper(root);
        return maxi;
    }
}