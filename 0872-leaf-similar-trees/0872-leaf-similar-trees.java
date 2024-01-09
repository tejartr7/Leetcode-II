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
    
    public void inorder(TreeNode root,StringBuilder s)
    {
        if(root==null)
            return ;
        inorder(root.left,s);
        if(root.left==null && root.right==null)
        {
            s.append(root.val);
            s.append(" ");
            return ;
        }
        inorder(root.right,s);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        inorder(root1,sb1);
        inorder(root2,sb2);
        //System.out.println(sb1+" "+sb2);
        return sb1.toString().equals(sb2.toString());
    }
}