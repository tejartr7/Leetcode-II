class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int i,j,m=box.length,n=box[0].length;
        char ans[][]=new char[n][m];
        for(i=0;i<m;i++)
        {
            int k=n-1;
            for(j=n-1;j>=0;j--)
            {
                if(box[i][j]=='*')
                {
                    k=j-1;
                }
                else if(box[i][j]=='#')
                {
                    box[i][j]='.';
                    box[i][k--]='#';
                }
            }
        }
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                ans[j][m-i-1] = box[i][j]; 
            }
        }

        return ans;
    }
}