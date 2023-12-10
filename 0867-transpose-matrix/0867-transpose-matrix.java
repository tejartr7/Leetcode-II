class Solution {
    public int[][] transpose(int[][] matrix) {
        int a=matrix.length;
        int b=matrix[0].length;
        
      int [][]r=new int[b][a];
        int i,j;
        for(i=0;i<a;i++)
        {
            for(j=0;j<b;j++)
            {
                r[j][i]=matrix[i][j];
            }
        }
        return r;
    }
}