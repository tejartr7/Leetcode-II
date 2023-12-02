class Solution {
    public boolean valid(int i,int j,int m,int n){
        return i>=0 && i<m && j>=0 &&j<n;
    }
    public int longestIncreasingPath(int[][] mat) {
        int i,j,m=mat.length,n=mat[0].length;
        int[][] dp=new int[m][n];
        int maxi=0;
        
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(dp[i][j]==0)
                {
                   maxi=Math.max(maxi,dfs(i,j,mat,dp)); 
                }
            }
        }
        return maxi;
    }
    public int dfs(int i,int j,int mat[][],int dp[][])
    {
        int m=mat.length,n=mat[0].length;
        if(!valid(i,j,m,n))
            return 0;
        if(dp[i][j]>0)
            return dp[i][j];
        int ans=1;
        if(valid(i+1,j,m,n) && mat[i+1][j]>mat[i][j])
        {
            ans=Math.max(ans,1+dfs(i+1,j,mat,dp));
        }
        if(valid(i-1,j,m,n) && mat[i-1][j]>mat[i][j])
        {
            ans=Math.max(ans,1+dfs(i-1,j,mat,dp));
        }
        if(valid(i,j+1,m,n) && mat[i][j+1]>mat[i][j])
        {
            ans=Math.max(ans,1+dfs(i,j+1,mat,dp));
        }
        if(valid(i,j-1,m,n) && mat[i][j-1]>mat[i][j])
        {
            ans=Math.max(ans,1+dfs(i,j-1,mat,dp));
        }
        return dp[i][j]=ans;
    }
}