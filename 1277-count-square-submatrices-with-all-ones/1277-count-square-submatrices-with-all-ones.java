class Solution {
    public int countSquares(int[][] matrix) {
        int i,j,m=matrix.length,n=matrix[0].length;
        int ans=0;
        for(i=1;i<m;i++){
            for(j=1;j<n;j++){
                if(matrix[i][j]==1){
                    int x=Integer.MAX_VALUE;
                    x=Math.min(x,matrix[i-1][j]);
                    x=Math.min(x,matrix[i][j-1]);
                    x=Math.min(x,matrix[i-1][j-1]);
                    matrix[i][j]=x+1;
                }
            }
        }
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                ans+=matrix[i][j];
            }
        }
        return ans;
    }
}