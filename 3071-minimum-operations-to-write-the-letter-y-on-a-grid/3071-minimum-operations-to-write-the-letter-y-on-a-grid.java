class Solution {
    Map<Integer,Integer> map1=new HashMap<>();
    Map<Integer,Integer> map2=new HashMap<>();
    int n;
    public int helper(int a,int b)
    {
        int x=n/2+n/2+(n+1)/2;
        int y=n*n;
        y-=x;
        x-=map1.getOrDefault(a,0);
        y-=map2.getOrDefault(b,0);
        return x+y;
    }
    public int minimumOperationsToWriteY(int[][] grid) {
        int i,j,m=grid.length,n=grid[0].length;
        boolean vis[][]=new boolean[m][n];
        this.n=n;
        i=0;j=0;
        for(i=0;i<n/2;i++)
        {
            //System.out.println(i+" "+j+" "+grid[i][j]);
            vis[i][i]=true;
            map1.put(grid[i][i],map1.getOrDefault(grid[i][i],0)+1);
        }
        //System.out.println(map1);
        i=0;j=n-1;
        while(i<n/2)
        {
            //System.out.println(grid[2][0]);
            vis[i][j]=true;
            map1.put(grid[i][j],map1.getOrDefault(grid[i][j],0)+1);
            i++;
            j--;
        }
        //System.out.println(map1);
        i=n/2;
        j=n/2;
        while(i<n)
        {
            vis[i][j]=true;
            map1.put(grid[i][j],map1.getOrDefault(grid[i][j],0)+1);
            i++;
        }
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(!vis[i][j]){
                    map2.put(grid[i][j],map2.getOrDefault(grid[i][j],0)+1);
                }
            }
        }
        int mini=1000_000_000;
        //System.out.println(map1);
        //System.out.println(map2);
        mini=Math.min(mini,helper(0,1));
        mini=Math.min(mini,helper(0,2));
        mini=Math.min(mini,helper(1,0));
        mini=Math.min(mini,helper(1,2));
        mini=Math.min(mini,helper(2,0));
        mini=Math.min(mini,helper(2,1));
        return mini;
    }
}