class Solution {
    public void helperR(int r, int[][] grid) {
    int n = grid[0].length;
    
    for (int j = 0; j < n; j++) {
        grid[r][j] = grid[r][j] == 1 ? 0 : 1;
    }
    }

    public void helperC(int c, int[][] grid) {
    int m = grid.length;
    
    for (int i = 0; i < m; i++) {
        grid[i][c] = grid[i][c] == 1 ? 0 : 1;
    }
    }
    public int matrixScore(int[][] grid) {
        int i,j,m=grid.length,n=grid[0].length;
        int ans=0;
        for(i=0;i<m;i++){
            if(grid[i][0]==0)
            {
                helperR(i,grid);
            }
        }
        for(j=0;j<n;j++){
            int cnt=0;
            for(i=0;i<m;i++){
                if(grid[i][j]==1)
                cnt++;
            }
            if(m-cnt>cnt)
                helperC(j,grid);
        }
        int temp=0;
        for(i=0;i<m;i++){
            int y=0;
            for(j=0;j<n;j++){
                //System.out.print(grid[i][j]+" ");
                if(grid[i][j]==1){
                    temp+=(1<<(n-1-j));
                }
            }
            //System.out.println();
        }
        return temp;
    }
}