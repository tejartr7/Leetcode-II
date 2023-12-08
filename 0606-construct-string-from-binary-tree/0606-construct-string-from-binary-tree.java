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
    public String helper(TreeNode root){
        String res="";
        if(root==null)
            return "()";
        if(root!=null && root.left==null && root.right==null)
            return "("+root.val+")";
        String l=helper(root.left);
        String r=helper(root.right);
        if(root.right==null)
            r="";
        return "("+root.val+l+r+")";
    }
    public String tree2str(TreeNode root) {
        if(root==null)
            return "()";
        String res=helper(root);
        return res.substring(1,res.length()-1);
    }
}