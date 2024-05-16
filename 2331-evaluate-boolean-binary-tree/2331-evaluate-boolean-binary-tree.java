class Solution {
    public boolean helper(TreeNode root){
        if(root.left==null && root.right==null){
            return root.val==1;
        }
        boolean left=helper(root.left);
        boolean right=helper(root.right);
        if(root.val==2) return left|right;
        return left&right;
    }
    public boolean evaluateTree(TreeNode root) {
        return helper(root);
    }
}