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
    public void helper(TreeNode root,String ans[],StringBuilder temp)
    {
        if(root==null)
        {
            return ;
        }
        if(root!=null && root.left==null && root.right==null)
        {
            temp.insert(0,(char)(root.val+97));
            int x=ans[0].compareTo(temp.toString());
            if(x>0)
                ans[0]=temp.toString();
            temp.deleteCharAt(0);
            return ;
        }
        temp.insert(0,(char)(root.val+97));
        helper(root.left,ans,temp);
        helper(root.right,ans,temp);
        temp.deleteCharAt(0);
        
    }
    public String smallestFromLeaf(TreeNode root) {
        String ans[]=new String[1];
        ans[0]="z".repeat(10000);
        helper(root,ans,new StringBuilder());
        return ans[0];
    }
}