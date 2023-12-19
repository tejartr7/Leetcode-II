class Solution {
    public boolean valid(int i,int j,int m,int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
    public int helper(int i,int j,int img[][])
    {
        int cnt=1;
        int sum=img[i][j];
        int m=img.length,n=img[0].length;
        if(valid(i+1,j,m,n))
        {
            cnt++;
            sum+=img[i+1][j];
        }
        if(valid(i-1,j,m,n))
        {
            cnt++;
            sum+=img[i-1][j];
        }
        if(valid(i,j+1,m,n))
        {
            cnt++;
            sum+=img[i][j+1];
        }
        if(valid(i,j-1,m,n))
        {
            cnt++;
            sum+=img[i][j-1];
        }
        if(valid(i+1,j+1,m,n))
        {
            cnt++;
            sum+=img[i+1][j+1];
        }
        if(valid(i-1,j+1,m,n))
        {
            cnt++;
            sum+=img[i-1][j+1];
        }
        if(valid(i+1,j-1,m,n))
        {
            cnt++;
            sum+=img[i+1][j-1];
        }
        if(valid(i-1,j-1,m,n))
        {
            cnt++;
            sum+=img[i-1][j-1];
        }
        return sum/cnt;
    }
    public int[][] imageSmoother(int[][] img) {
        int i,j,m=img.length,n=img[0].length;
        int[][] ans=new int[m][n];
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                ans[i][j]=helper(i,j,img);
            }
        }
        return ans;
    }
}