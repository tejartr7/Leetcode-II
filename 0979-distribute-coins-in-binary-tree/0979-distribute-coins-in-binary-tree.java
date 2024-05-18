class Solution {
    int ans=0;
    public int[] helper(TreeNode root){
        if(root==null) return new int[2];
        int x[]=helper(root.left);
        int y[]=helper(root.right);
        int cnt=x[0]+y[0]+1;
        int coins=x[1]+y[1]+root.val;
        ans+=Math.abs(cnt-coins);
        return new int[]{cnt,coins};
    }
    public int distributeCoins(TreeNode root) {
        helper(root);
        return ans;
    }
}