class tuple
{
    int r;
    int c;
    int val;
    tuple(int x,int y,int z)
    {
        r=x;
        c=y;
        val=z;
    }
}
class Solution {
    public boolean valid(int i,int j,int m,int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
    public int minimumEffortPath(int[][] h) {
        PriorityQueue<tuple>pq=new PriorityQueue<>((a,b)->a.val-b.val);  
        int i,j,m=h.length,n=h[0].length;
        pq.offer(new tuple(0,0,0));
        boolean[][]vis=new boolean[m][n];
        while(!pq.isEmpty())
        {
            tuple top=pq.poll();
            int r=top.r;
            int c=top.c;
            int val=top.val;
            if(r==m-1 && c==n-1)
                return val;
            vis[r][c]=true;
            //h[r][c]=-1;
            if(valid(r+1,c,m,n) && !vis[r+1][c])
            {
                int temp=Math.max(Math.abs(h[r][c]-h[r+1][c]),val);
                pq.offer(new tuple(r+1,c,temp));
               // h[r+1][c]=-1;
            }
            if(valid(r-1,c,m,n) && !vis[r-1][c])
            {
                int temp=Math.max(Math.abs(h[r][c]-h[r-1][c]),val);
                pq.offer(new tuple(r-1,c,temp));
                //h[r-1][c]=-1;
            }
            if(valid(r,c+1,m,n) && !vis[r][c+1])
            {
                int temp=Math.max(Math.abs(h[r][c]-h[r][c+1]),val);
                pq.offer(new tuple(r,c+1,temp));
                //h[r][c+1]=-1;
            }
            if(valid(r,c-1,m,n) && !vis[r][c-1])
            {
                int temp=Math.max(Math.abs(h[r][c]-h[r][c-1]),val);
                pq.offer(new tuple(r,c-1,temp));
               // h[r][c-1]=-1;
            }
        }
        return -1;
    }
}