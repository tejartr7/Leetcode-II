class Solution {
    String ans;
    public void helper(TreeNode root,String s)
    {
        if(root==null)
        {
            return ;
        }
        if(root.left==null && root.right==null)
        {
            String temp=(char)(root.val+'a')+s;
            if(temp.compareTo(ans)<0)
            {
                ans=temp;
            }
            return ;
        }
        String temp=(char)(root.val+'a')+s;
        helper(root.left,temp);
        helper(root.right,temp);
    }
    public String smallestFromLeaf(TreeNode root) {
        ans="z".repeat(10000);
        helper(root,"");
        return ans;
    }
}