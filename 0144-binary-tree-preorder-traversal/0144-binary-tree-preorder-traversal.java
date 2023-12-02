
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if(root==null)
        return ans;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode temp=stack.pop();
            ans.add(temp.val);
            if(temp.right!=null)
            stack.push(temp.right);
            if(temp.left!=null)
            stack.push(temp.left);
        }
        return ans;
    }
    
}