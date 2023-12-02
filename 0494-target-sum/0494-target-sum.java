class Solution {
    int dp[][];
    public int helper(int idx,int nums[],int sum,int target)
    {
        int n=nums.length;
        if(idx>=n)
        {
            return target==sum?1:0;
        }
        if(dp[idx][sum+1000]!=-1)
            return dp[idx][sum+1000];
        int add=helper(idx+1,nums,sum+nums[idx],target);
        int sub=helper(idx+1,nums,sum-nums[idx],target);
        return dp[idx][sum+1000]=add+sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        dp=new int[nums.length][2001];
        for(int x[]:dp)
        Arrays.fill(x,-1);
        return helper(0,nums,0,target);
    }
}