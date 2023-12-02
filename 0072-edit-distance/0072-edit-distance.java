class Solution {
    public int minDistance(String word1, String word2) {
        int i,j;
        int m=word1.length(),n=word2.length();
        int dp[][]=new int[m+1][n+1];
        for(i=0;i<=m;i++)
        {
            dp[i][0]=i;
        }
        for(j=0;j<=n;j++)
        {
            dp[0][j]=j;
        }
        for(i=1;i<=m;i++)
        {
            for(j=1;j<=n;j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else
                {
                    int x=dp[i-1][j];
                    int y=dp[i][j-1];
                    int z=dp[i-1][j-1];
                    dp[i][j]=Math.min(x,Math.min(y,z))+1;
                }
            }
        }
        return dp[m][n];
    }
}