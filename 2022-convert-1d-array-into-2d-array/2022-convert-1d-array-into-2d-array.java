class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int i,j,l=original.length,k=0;
        int [][]ans=new int[m][n]; 
        int [][]empty={};
        if(l!=m*n)
            return empty;
        for(i=0;i<m;i++)
        {
            for(j=0;j<n;j++)
            {
                if(k<l){
                    ans[i][j]=original[k++];
                }
            }
        }
        return ans;
    }
}