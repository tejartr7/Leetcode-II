class Solution {
    int sum=0;
    public void helper(TreeNode root,int l)
    {
        if(root==null) return ;
        if(l==1 && root.left==null && root.right==null) sum+=root.val;
        helper(root.left,1);
        helper(root.right,0);
    }
    public int sumOfLeftLeaves(TreeNode root) {
       if(root==null) return 0;
       helper(root,0);
       return sum; 
    }
}