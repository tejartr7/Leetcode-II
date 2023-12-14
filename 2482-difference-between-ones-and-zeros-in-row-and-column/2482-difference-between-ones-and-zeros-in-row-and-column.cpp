class Solution {
public:
    vector<vector<int>> onesMinusZeros(vector<vector<int>>& grid) {
        int i,j,m=grid.size(),n=grid[0].size();
        vector<int> row1(m,0);
        vector<int> col1(n,0);
        vector<int> row2(m,0);
        vector<int> col2(n,0);
        for(i=0;i<m;i++)
        {
            int sum=0;
            for(j=0;j<n;j++)
                sum+=grid[i][j];
            row1[i]=sum;
            row2[i]=n-sum;
        }
        for(i=0;i<n;i++)
        {
            int sum=0;
            for(j=0;j<m;j++)
                sum+=grid[j][i];
            col1[i]=sum;
            col2[i]=m-sum;
        }
        vector<vector<int>> arr(m,vector<int>(n,0));
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                arr[i][j]=row1[i]+col1[j]-row2[i]-col2[j];
            }
        }
        return arr;
    }
};