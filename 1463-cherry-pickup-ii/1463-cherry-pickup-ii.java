class Solution {
    int dp[][][];
    public boolean valid(int i,int j,int m,int n)
    {
        return i>=0 && i<m && j>=0 && j<n;
    }
    public int helper(int i,int j1,int j2,int[][] grid)
    {
        int m=grid.length,n=grid[0].length;
        if(!valid(i,j1,m,n) || !valid(i,j2,m,n))
            return -1000_000_000;
        if(i==m-1)
        {
            if(j1==j2)
                return grid[i][j1];
            return grid[i][j1]+grid[i][j2];
        }
        if(dp[i][j1][j2]!=-1)
            return dp[i][j1][j2];
        int maxi=0;
        int dirs[]={-1,0,1};
        for(int x:dirs)
        {
            for(int y:dirs)
            {
                if(j1==j2)
                {
                    maxi=Math.max(maxi,grid[i][j1]+helper(i+1,j1+x,j2+y,grid));
                }
                else
                {
                    maxi=Math.max(maxi,grid[i][j1]+grid[i][j2]+helper(i+1,j1+x,j2+y,grid));
                }
            }
        }
        return dp[i][j1][j2]=maxi;
    }
    public int cherryPickup(int[][] grid) {
        dp=new int[71][71][71];
        for(int x[][]:dp)
        {
            for(int y[]:x){
                Arrays.fill(y,-1);
            }
        }
        return helper(0,0,grid[0].length-1,grid);
    }
}