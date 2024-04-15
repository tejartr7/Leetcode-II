class Solution {
    int ans=0;
    public void sum(TreeNode root,int x)
    {
        if(root==null)
        {
            return ;
        }
        if(root!=null && root.left==null && root.right==null)
        {
            x=x*10+root.val;
            ans+=x;
            return ;
        }
        sum(root.left,x*10+root.val);
        sum(root.right,x*10+root.val);
    }
    public int sumNumbers(TreeNode root) {
        sum(root,0);
        return ans;
    }
}