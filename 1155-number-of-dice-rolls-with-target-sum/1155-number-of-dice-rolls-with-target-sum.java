class Solution {
    int dp[][];
    int mod=1000_000_007;
    public int helper(int sum,int n,int k,int target)
    {
        if(n==0)
            return target==sum?1:0;
        if(target==0)
            return 0;
        if(sum>target)
            return 0;
        int ans=0;
        if(dp[n][sum]!=-1)
            return dp[n][sum];
        for(int i=1;i<=k;i++)
        {
            ans=(ans%mod+helper(sum+i,n-1,k,target)%mod)%mod;
        }
        return dp[n][sum]=ans%mod;
    }
    public int numRollsToTarget(int n, int k, int target) {
        dp=new int[n+1][target+1];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        return helper(0,n,k,target);
    }
}