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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        //list.add(root.val);
        int i,j;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(q.size()>0)
        {
            int n=q.size();
            long maxi=Long.MIN_VALUE;
            
            for(i=0;i<n;i++)
            {
                TreeNode top=q.poll();
                maxi=Math.max(maxi,top.val);
                if(top.left!=null)
                    q.offer(top.left);
                if(top.right!=null)
                    q.offer(top.right);
            }
            if(maxi!=Long.MIN_VALUE)
                list.add((int)maxi);
        }
        return list;
    }
}