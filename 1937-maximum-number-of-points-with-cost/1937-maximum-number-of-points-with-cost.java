class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        int i,j;
        long[][] dp = new long[m][n];
        for (j = 0; j < n; j++) {
            dp[0][j] = points[0][j];
        }

        for(i=1;i<m;i++){
            long left[]=new long[n];
            long right[]=new long[n];
            left[0]=dp[i-1][0];
            for(j=1;j<n;j++){
                left[j]=Math.max(left[j-1]-1,dp[i-1][j]);
            }
            right[n-1]=dp[i-1][n-1];
            for(j=n-2;j>=0;j--){
                right[j]=Math.max(right[j+1]-1,dp[i-1][j]);
            }
            for(j=0;j<n;j++){
                dp[i][j]=Math.max(left[j],right[j])+points[i][j];
            }
        }
        long ans = 0;
        for (long value : dp[m-1]) {
            ans = Math.max(ans, value);
        }

        return ans;
    }
}
