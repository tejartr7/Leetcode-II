class Solution {
    int dp[][];
    public int recursion(int idx,int s,int prices[])
    {
        if(idx>=prices.length)
            return 0;
        if(dp[idx][s]!=-1)
            return dp[idx][s];
        int buy=0;
        if(s==0)
        {
            return dp[idx][s]=Math.max(-prices[idx]+recursion(idx+1,1,prices),recursion(idx+1,s,prices));
        }
        return dp[idx][s]=Math.max(prices[idx]+recursion(idx+2,0,prices),recursion(idx+1,1,prices));
    }
    public int maxProfit(int[] prices) {
        dp=new int[prices.length][2];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        return recursion(0,0,prices);
    }
}