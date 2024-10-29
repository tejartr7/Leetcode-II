class Solution {
    int dp[][];
    int m,n;
    boolean vis[][];
    public boolean valid(int i,int j){
        return i>=0 && i<m && j>=0 && j<n;
    }
    public int helper(int i,int j,int grid[][],boolean vis[][]){
        if(!valid(i,j) || vis[i][j]) return 0;
        vis[i][j]=true;
        int ans=0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(valid(i-1,j+1) && grid[i-1][j+1]>grid[i][j]){
            ans=Math.max(ans,1+helper(i-1,j+1,grid,vis));
        }
        if(valid(i,j+1) && grid[i][j+1]>grid[i][j]){
            ans=Math.max(ans,1+helper(i,j+1,grid,vis));
        }
        if(valid(i+1,j+1) && grid[i+1][j+1]>grid[i][j]){
            ans=Math.max(ans,1+helper(i+1,j+1,grid,vis));
        }
        return dp[i][j]=ans;
    }
    public int maxMoves(int[][] grid) {
        int i,j;
        this.m=grid.length;
        this.n=grid[0].length;
        dp=new int[m+1][n+1];
        for(int x[]:dp){
            Arrays.fill(x,-1);
        }
        j=0;
        int ans=0;
        for(i=0;i<m;i++){
            vis=new boolean[m][n];
            ans=Math.max(ans,helper(i,0,grid,vis));
        }
        return ans;
    }
}