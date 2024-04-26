class pair{
    int x,y;
    pair(int a,int b){
        x=a;
        y=b;
    }
}
class Solution {
    public int minFallingPathSum(int[][] grid) {
        int i,j,m=grid.length,n=grid[0].length;
        int ans=1000_000_000;
        if(m==1) return grid[0][0];
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.x-b.x);
        i=0;
        for(i=1;i<m;i++){
            int x=i-1;
            for(j=0;j<n;j++){
                pq.offer(new pair(grid[x][j],j));
            }
            for(j=0;j<n;j++){
                pair top=pq.peek();
                if(top.y!=j)
                {
                    grid[i][j]+=top.x;
                }
                else{
                top=pq.poll();
                grid[i][j]+=pq.peek().x;
                pq.offer(new pair(top.x,top.y));
                }
            }
            pq.clear();
        }
        i=n-1;
        for(j=0;j<n;j++){
            ans=Math.min(ans,grid[i][j]);
        }
        return ans;
    }
}