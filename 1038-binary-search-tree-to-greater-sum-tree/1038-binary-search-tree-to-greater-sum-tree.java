class Solution {
    Stack<TreeNode> stack;
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        stack.push(root);
        inorder(root.right);
    }
    public TreeNode bstToGst(TreeNode root) {
        stack = new Stack<>();
        inorder(root);
        int sum=0;
        while(!stack.isEmpty()){
            TreeNode top=stack.pop();
            top.val+=sum;
            sum=top.val;
        }
        return root;
    }
}