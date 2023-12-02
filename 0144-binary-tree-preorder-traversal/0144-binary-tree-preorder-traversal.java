class pair{
    TreeNode node;
    int num;
    pair(TreeNode a,int b){
        node=a;
        num=b;
    }
}
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<pair> stack=new Stack<>();
        List<Integer> pre=new ArrayList<>();
        List<Integer> in=new ArrayList<>();
        List<Integer> post=new ArrayList<>();
        if(root==null)
        return in;
        stack.push(new pair(root,1));
        while(stack.size()>0)
        {
            pair top=stack.pop();
            if(top.num==1)
            {
                pre.add(top.node.val);
                stack.push(new pair(top.node,top.num+1));
                if(top.node.left!=null)
                    stack.push(new pair(top.node.left,1));
            }
            else if(top.num==2)
            {
                in.add(top.node.val);
                stack.push(new pair(top.node,top.num+1));
                if(top.node.right!=null)
                    stack.push(new pair(top.node.right,1));
            }
            else{
                post.add(top.node.val);
            }
        }
        return pre;
    }
}