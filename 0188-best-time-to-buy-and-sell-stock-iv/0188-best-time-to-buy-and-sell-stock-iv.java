class Solution {
    public int helper(int i,int b,int c,int p[],int dp[][][])
    {
        if(i==p.length) return 0;
        if(c==0) return 0;
        if(dp[i][b][c]!=-1) return dp[i][b][c];
        int pro=0;
        if(b==1)
        {
            pro=Math.max(-p[i]+helper(i+1,0,c,p,dp),helper(i+1,1,c,p,dp));
        }
        else
        {
            pro=Math.max(p[i]+helper(i+1,1,c-1,p,dp),helper(i+1,0,c,p,dp));
        }
        return dp[i][b][c]=pro;
    }
    public int maxProfit(int c,int[] prices) {
        int dp[][][]=new int[prices.length][2][c+1];
        int i,j;
        for(i=0;i<prices.length;i++)
        {
            for(j=0;j<2;j++)
            Arrays.fill(dp[i][j],-1);
        }
        return helper(0,1,c,prices,dp);
    }
}