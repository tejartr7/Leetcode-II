class Solution {
    public int rob(int[] nums) {
        int i,n=nums.length;
        int dp[]=new int[n];
        if(n<=0)
        return 0;
        if(n==1)
        return nums[0];
        if(n==2)
        return Math.max(nums[0],nums[1]);
        dp[0]=nums[0];
       // dp[1]=Math.max(nums[0],nums[1]);
        for(i=1;i<n;i++)
        {
            int x=nums[i];
            if(i>1)
                x+=dp[i-2];
            dp[i]=Math.max(x,dp[i-1]);
        }
        return dp[n-1];
    }
}