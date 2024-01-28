class Solution {
public int numSubmatrixSumTarget(int[][] matrix, int target) {

    int dp[][]=new int[matrix.length][matrix[0].length];
    for(int i=0;i<matrix[0].length;i++)
    {
        int sum=0;
        for(int j=matrix.length-1;j>=0;j--)
        {
            sum+=matrix[j][i];
            dp[j][i]=sum;
        }
    }
    int ans=0;
    for(int i=0;i<dp.length;i++)
    {
        for(int j=0;j<matrix[0].length;j++)
        {
           for(int p=i;p>=0;p--)
           {
              int sum=0; 
              for(int k=j;k>=0;k--)
              {
                 if(i==dp.length-1)
                 {
                     sum+=dp[p][k];
                 }
                 else
                     sum+=dp[p][k]-dp[i+1][k];
                 if(sum==target)
                 {
                     ans++;
                 }
              }
           }
        }
    }
    return ans;
}
}