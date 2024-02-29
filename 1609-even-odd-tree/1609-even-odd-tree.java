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
    public boolean isEvenOddTree(TreeNode root) {
        int x=0;
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return true;
        q.offer(root);
        while(!q.isEmpty())
        {
            int i,n=q.size();
            if(x%2==0)
            {
                int prev=-1;
                for(i=0;i<n;i++)
                {
                    TreeNode top=q.poll();
                    if(top.val%2==0) return false;
                    if(prev>=top.val) return false;
                    if(top.left!=null) q.offer(top.left);
                    if(top.right!=null)q.offer(top.right);
                    prev=top.val;
                }
            }
            else
            {
                int prev=Integer.MAX_VALUE;
                for(i=0;i<n;i++)
                {
                    TreeNode top=q.poll();
                    if(top.val%2==1) return false;
                    if(prev<=top.val) return false;
                    if(top.left!=null) q.offer(top.left);
                    if(top.right!=null)q.offer(top.right);
                    prev=top.val;
                }
            }
            x++;
        }
        return true;
    }
}