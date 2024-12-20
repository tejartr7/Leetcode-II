class Solution {
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
        inorder(left.right,right.left,!flag);
        inorder(left.left,right.right,!flag);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        inorder(root.left,root.right,true);
        return root;
    }
}