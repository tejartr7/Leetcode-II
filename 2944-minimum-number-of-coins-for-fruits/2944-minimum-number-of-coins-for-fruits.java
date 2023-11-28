class Solution {
    int dp[][];
    public int helper(int idx,int f,int[] prices)
    {
        int i,j,n=prices.length;
        //System.out.println(idx+" "+taken);
        if(idx>=n)
            return 0;
        if(dp[idx][f]!=-1)
            return dp[idx][f];
        int notFree=prices[idx]+helper(idx+1,idx+1,prices);
        int free=Integer.MAX_VALUE;
        if(f>0)
        {
            free=helper(idx+1,f-1,prices);
        }
        return dp[idx][f]=Math.min(free,notFree);
    }
    public int minimumCoins(int[] prices) {
        dp=new int[1001][1001];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        return helper(0,0,prices);
    }
}