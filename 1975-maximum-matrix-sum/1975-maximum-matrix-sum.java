class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int neg=0;
        int mini=1000_000_000;
        long ans=0;
        int i,j,m=matrix.length,n=matrix[0].length;
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                ans+=Math.abs(matrix[i][j]);
                if(matrix[i][j]<0){
                    neg++;
                }
                mini=Math.min(mini,Math.abs(matrix[i][j]));
            }
        }
        if(neg%2==0) return ans;
        return ans-2*mini;
    }
}