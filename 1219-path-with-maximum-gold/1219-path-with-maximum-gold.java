class Solution {
    int maxi=0;
    public boolean valid(int i,int j,int m,int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
    public void helper(int i,int j,int grid[][],boolean vis[][],int cnt[]){
        int m=grid.length,n=grid[0].length;
        if(!valid(i,j,m,n) || vis[i][j] || grid[i][j]==0) {
            maxi=Math.max(maxi,cnt[0]);
            return ;
        }
        vis[i][j]=true;
        int x=grid[i][j];
        cnt[0]+=x;
        helper(i+1,j,grid,vis,cnt);
        helper(i-1,j,grid,vis,cnt);
        helper(i,j+1,grid,vis,cnt);
        helper(i,j-1,grid,vis,cnt);
        cnt[0]-=x;
        vis[i][j]=false;
    }
    public int getMaximumGold(int[][] grid) {
        maxi=0;
        int i,j,m=grid.length,n=grid[0].length;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(grid[i][j]!=0){
                    boolean vis[][]=new boolean[m][n];
                    helper(i,j,grid,vis,new int[1]);
                }
            }
        }
        return maxi;
    }
}