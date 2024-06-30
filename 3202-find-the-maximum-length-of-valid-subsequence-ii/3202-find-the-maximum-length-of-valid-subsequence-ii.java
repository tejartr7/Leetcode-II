class Solution {
    public int maximumLength(int[] nums, int k) {
        int i,j,n=nums.length;
        int dp[][]=new int[k+1][k+1];
        int ans=1;
        for(i=0;i<n;i++){
            int curr=nums[i]%k;
            for(j=0;j<k;j++){
                int prev=(j-curr+k)%k;
                dp[curr][j]=Math.max(dp[curr][j],1+dp[prev][j]);
                ans=Math.max(ans,dp[curr][j]);
            }
        }
        return ans;
    }
}