class pair{
    int x,y;
    pair(int a,int b){
        x=a;
        y=b;
    }
}
class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int i,j,m=grid.length,n=grid[0].length;
        pair[][] temp=new pair[m][n];
        int cnt=0;
        for(i=0;i<m;i++){
            pair x=new pair(0,0);
            for(j=0;j<n;j++){
                char ch=grid[i][j];
                if(ch=='X'){
                    x=new pair(x.x+1,x.y);
                }
                else if(ch=='Y'){
                    x=new pair(x.x,x.y+1);
                }
                temp[i][j]=new pair(x.x,x.y);
            }
        }
        for(j=0;j<n;j++){
            pair x=new pair(temp[0][j].x,temp[0][j].y);
            for(i=1;i<m;i++){
                pair y=new pair(temp[i][j].x,temp[i][j].y);
                x=new pair(x.x+y.x,x.y+y.y);
                temp[i][j]=new pair(x.x,x.y);
            }
        }
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                pair x=temp[i][j];
                if(x.x>0 && x.x==x.y){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}