
class Solution {
   // int ans=0;
    public int maxDepth(TreeNode root,int ans[]) {
        // Base Condition
        if(root == null) return 0;
        // Hypothesis
        int left = maxDepth(root.left,ans);
        int right = maxDepth(root.right,ans);
        // Induction
        ans[0]=Math.max(ans[0],left+right);
        return Math.max(left, right) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int dp[]=new int[1];
        maxDepth(root,dp);
        return dp[0];
    }
}