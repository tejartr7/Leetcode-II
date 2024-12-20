class Solution {
    boolean flag=false;
    public void inorder(TreeNode left,TreeNode right,boolean flag)
    {
        if(left==null)
        return ;
        if(flag)
        {
            int temp=left.val;
            left.val=right.val;
            right.val=temp;
        }
        flag=!flag;
        inorder(left.right,right.left,flag);
        inorder(left.left,right.right,flag);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        flag=!flag;
        inorder(root.left,root.right,flag);
        return root;
    }
}