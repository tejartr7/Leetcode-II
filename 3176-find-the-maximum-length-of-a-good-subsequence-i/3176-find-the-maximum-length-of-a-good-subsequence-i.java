class Solution {
    int dp[][];
    public int helper(int i,int k,int nums[]){
        int n=nums.length;
        if(i>=n) return 0;
        if(dp[i][k]!=-1) return dp[i][k];
        int ans=1;
        for(int x=i-1;x>=0;x--){
            if(nums[i]==nums[x]){
                ans=Math.max(ans,1+helper(x,k,nums));
            }
            else if(nums[i]!=nums[x] && k>0){
                ans=Math.max(ans,1+helper(x,k-1,nums));
            }
        }
        return dp[i][k]=ans;
    }
    public int maximumLength(int[] nums, int k) {
        dp=new int[501][26];
        for(int x[]:dp) Arrays.fill(x,-1);
        int i,j,n=nums.length;
        int ans=0;
        for(i=0;i<n;i++){
            ans=Math.max(ans,helper(i,k,nums));
        }
        return ans;
    }
}