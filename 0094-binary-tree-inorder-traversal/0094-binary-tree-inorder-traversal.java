class Solution {
    private List<Integer> answer = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<>();
       // stack.push(root);
       TreeNode node=root;
        while(true)
        {
            if(node!=null)
            {
                stack.push(node);
                node=node.left;
            }
            else
            {
                if(stack.isEmpty())
                break;
                node=stack.pop();
                answer.add(node.val);
                node=node.right;
            }
        }
        return answer;
    }
}