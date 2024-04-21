class Solution {
    boolean vis[][];
    public int[][] findFarmland(int[][] land) {
        int m=land.length,n=land[0].length;
        List<int[]> list=new ArrayList<>();
        vis=new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(land[i][j] == 1 && ((i == 0 || land[i-1][j] == 0) && (j == 0  || land[i][j-1] == 0))){
                    int i_ = i, j_ = j;
                    while(i_ < m && land[i_][j_] == 1)
                        i_++;
                    i_--;
                    while(j_ < n && land[i_][j_] == 1)
                        j_++;
                    j_--;

                    list.add(new int[]{i,j,i_,j_});
                    j = j_;
                }
            }
        }  
        int [][] ans=new int[list.size()][4];
        for(int i=0;i<ans.length;i++)
            ans[i]=list.get(i);
        return ans;
    }
}