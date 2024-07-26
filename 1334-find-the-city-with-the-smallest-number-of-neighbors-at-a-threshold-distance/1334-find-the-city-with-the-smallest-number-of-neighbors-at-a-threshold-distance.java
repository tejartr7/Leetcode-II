class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int i,j,k;
        int matrix[][]=new int[n][n];
        for(i=0;i<n;i++)
            Arrays.fill(matrix[i],-1);
        int l=edges.length;
        for(i=0;i<l;i++)
        {
            int a=edges[i][0];
            int b=edges[i][1];
            int c=edges[i][2];
            matrix[a][b]=matrix[b][a]=c;
        }
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(i==j)
                    matrix[i][j]=0;
                else if(matrix[i][j]==-1)
                    matrix[i][j]=1000000;
            }
        }
        for(k=0;k<n;k++)
        {
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
        int count=Integer.MAX_VALUE;
        int ans=-1;
        for(i=0;i<n;i++)
        {
            int cnt=0;
            for(j=0;j<n;j++)
            {
                if(matrix[i][j]<=distanceThreshold)
                {
                    cnt++;
                }
            }
            if(count>cnt)
            {
                ans=i;
                count=cnt;
            }
            else if(count==cnt)
            {
                ans=Math.max(ans,i);
            }
        }
        return ans;
    }
}