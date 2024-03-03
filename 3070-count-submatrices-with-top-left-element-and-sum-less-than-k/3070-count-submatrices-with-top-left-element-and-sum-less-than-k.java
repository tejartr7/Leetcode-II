class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int i,j,m=grid.length,n=grid[0].length;
        for(j=0;j<n;j++)
        {
            for(i=1;i<m;i++)
            {
                grid[i][j]+=grid[i-1][j];
            }
        }
        for(i=0;i<m;i++)
        {
            int temp=0;
            for(j=1;j<n;j++)
            {
                grid[i][j]+=grid[i][j-1];
            }
        }
        int cnt=0;
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(grid[i][j]<=k)
                    cnt++;
            }
        }
        return cnt;
    }
}