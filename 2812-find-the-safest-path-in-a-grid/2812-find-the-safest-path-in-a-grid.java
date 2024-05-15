class tuple
{
    int r,c,val;
    tuple(int a,int b,int x)
    {
        r=a;
        c=b;
        val=x;
    }
}
class Solution {
    int dp[][];
    boolean vis[][];
    int[][] dirArr = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    public boolean valid(int i,int j,int m,int n)
    {
        return i>=0 && i<m && j>=0 && j<n;
    }
    public void dfs(int i,int j,int x,int y,List<List<Integer>> grid)
    {
        int m=grid.size(),n=grid.get(0).size();
        if(!valid(i,j,m,n) || vis[i][j])
            return ;
        dp[i][j]=Math.min(dp[i][j],Math.abs(x-i)+Math.abs(y-j));
        vis[i][j]=true;
        dfs(i+1,j,x,y,grid);
        dfs(i-1,j,x,y,grid);
        dfs(i,j+1,x,y,grid);
        dfs(i,j-1,x,y,grid);
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int i,j,m=grid.size(),n=grid.get(0).size();
        if(grid.get(0).get(0)==1 || grid.get(m-1).get(n-1)==1)
            return 0;
        dp=new int[m+1][n+1];
        for(i=0;i<=m;i++)
            Arrays.fill(dp[i],1000_000_000);
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(i=0;i<m;i++)
            for(j=0;j<n;j++){
                if(grid.get(i).get(j)==1){
                    queue.add(new int[]{i,j,0});  
                    // since node has thief himself
                    dp[i][j]=0;
                } else dp[i][j]=Integer.MAX_VALUE;                     
            }            
        // bfs to fill safety for all nodes        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int[] curr = queue.poll();
                int currx = curr[0];
                int curry = curr[1];
                for(int[] dir:dirArr){
                    int nextx = currx+dir[0];
                    int nexty = curry+dir[1];
                    if(valid(nextx, nexty, m,n) && curr[2]+1 < dp[nextx][nexty]){
                        queue.add(new int[]{nextx, nexty, curr[2]+1});
                        dp[nextx][nexty]=curr[2]+1;
                    }
                }                
            }
        }
      
        //vis=new boolean[m+1][n+1]
        PriorityQueue<tuple> pq=new PriorityQueue<>((a,b)->b.val-a.val);
        pq.offer(new tuple(0,0,dp[0][0]));
        while(pq.size()>0)
        {
            tuple top=pq.poll();
            int x=top.r;
            int y=top.c;
            int val=top.val;
            if(x==m-1 && y==n-1)
                return val;
            if(valid(x+1,y,m,n) && dp[x+1][y]!=-1)
            {
                pq.offer(new tuple(x+1,y,Math.min(val,dp[x+1][y])));
                dp[x+1][y]=-1;
            }
            if(valid(x-1,y,m,n) && dp[x-1][y]!=-1)
            {
                pq.offer(new tuple(x-1,y,Math.min(val,dp[x-1][y])));
                dp[x-1][y]=-1;
            }
            if(valid(x,y+1,m,n) && dp[x][y+1]!=-1)
            {
                pq.offer(new tuple(x,y+1,Math.min(val,dp[x][y+1])));
                dp[x][y+1]=-1;
            }
            if(valid(x,y-1,m,n) && dp[x][y-1]!=-1)
            {
                pq.offer(new tuple(x,y-1,Math.min(val,dp[x][y-1])));
                dp[x][y-1]=-1;
            }
        }
        return -1;
    }
}