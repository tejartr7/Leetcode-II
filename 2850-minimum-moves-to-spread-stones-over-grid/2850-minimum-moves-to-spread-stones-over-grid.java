class Solution {
    
    boolean valid(int[][] grid) {
        int i,j;
        for(i=0;i<3;i++)
            for(j=0;j<3;j++)
                if(grid[i][j]!=1)
                    return false;
        return true;
    }
    public int helper(int[][] grid)
    {
        int a,b,c,d;
        if(valid(grid))
            return 0;
        int ans=1000_000_000;
        for(a=0;a<3;a++)
        {
            for(b=0;b<3;b++)
            {
                if(grid[a][b]==0)
                {
                    grid[a][b]=1;
                    for(c=0;c<3;c++)
                    {
                        for(d=0;d<3;d++)
                        {
                            if(grid[c][d]>1)
                            {
                                grid[c][d]-=1;
                                ans=Math.min(ans,Math.abs(a-c)+Math.abs(b-d)+helper(grid));
                                grid[c][d]+=1;
                            }
                        }
                    }
                    grid[a][b]=0;
                }
            }
        }
        return ans;
    }
    public int minimumMoves(int[][] grid) {
       return helper(grid);
    }
}
