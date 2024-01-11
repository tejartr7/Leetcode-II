import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int find(TreeNode root,int min,int max)
    {
        if(root==null)
            return max-min;
        min=Math.min(min,root.val);
        max=Math.max(max,root.val);
        int left=find(root.left,min,max);
        int right=find(root.right,min,max);
        return Math.max(left,right);
    }
    public int maxAncestorDiff(TreeNode root) {
        if(root==null)
            return 0;
        return find(root,root.val,root.val);
    }
}