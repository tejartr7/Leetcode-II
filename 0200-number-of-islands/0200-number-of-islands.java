class pair
{
    int row;
    int col;
    pair(int row,int col)
    {
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public boolean isValid(int i,int j,int m,int n)
    {
        return i>=0 && i<m && j>=0 && j<n;
    }
    public void dfs(int i,int j,char [][]grid,boolean visited[][])
    {
        int m=grid.length,n=grid[0].length;
        if(!isValid(i,j,m,n) || visited[i][j]) return ;
        visited[i][j]=true;
        if(grid[i][j]=='1')
        {
            dfs(i+1,j,grid,visited);
            dfs(i-1,j,grid,visited);
            dfs(i,j-1,grid,visited);
            dfs(i,j+1,grid,visited);
        }
    }
    public int numIslands(char[][] grid) {
        int i,j,m=grid.length,n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        int count=0;
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(!visited[i][j] && grid[i][j]=='1')
                {
                    count++;
                    dfs(i,j,grid,visited);
                }
            }
        }
        //System.out.println(x);
        return count;
    }
}