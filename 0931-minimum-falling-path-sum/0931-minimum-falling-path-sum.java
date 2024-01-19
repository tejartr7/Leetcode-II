class Solution {
    public boolean valid(int i,int j,int m,int n)
    {
        return i>=0 && i<m && j>=0 && j<n;
    }
    public int minFallingPathSum(int[][] matrix) {
        int i,j,m=matrix.length,n=matrix[0].length;
        int ans=Integer.MAX_VALUE;
        if(m==1){
        for(int x:matrix[0])
            ans=Math.min(ans,x);
        return ans;
        }
        for(i=1;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                int temp=Integer.MAX_VALUE;
                if(valid(i-1,j,m,n))
                    temp=Math.min(temp,matrix[i-1][j]);
                if(valid(i-1,j+1,m,n))
                    temp=Math.min(temp,matrix[i-1][j+1]);
                if(valid(i-1,j-1,m,n))
                    temp=Math.min(temp,matrix[i-1][j-1]);
                matrix[i][j]+=temp;
                if(i==m-1)
                    ans=Math.min(ans,matrix[i][j]);
            }
        }
        return ans;
    }
}