class Solution {
    int m,n;
    boolean vis[][];
    public boolean valid(int i,int j,int m,int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
    public boolean dfs(int i,int j,int [][]a,int [][]b){
        if(!valid(i,j,m,n) || vis[i][j]) return true;
        if(b[i][j]==1 && a[i][j]!=1) return false;
        if(b[i][j]==0) return true;
        vis[i][j]=true;
        boolean x=dfs(i+1,j,a,b);
        x&=dfs(i-1,j,a,b);
        x&=dfs(i,j+1,a,b);
        x&=dfs(i,j-1,a,b);
        return x;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int i,j;
        m=grid1.length;n=grid1[0].length;
        vis=new boolean[m][n];
        int ans=0;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                if(grid2[i][j]==1 && !vis[i][j]){
                    if(dfs(i,j,grid1,grid2)){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}