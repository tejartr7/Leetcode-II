class pair{
    int x,y;
    pair(int a,int b)
    {
        x=a;
        y=b;
    }
}
class Solution {
    
    public long[] unmarkedSumArray(int[] nums, int[][] queries) {
        int i,j,n=nums.length,q=queries.length;
        long []ans=new long[q];
        boolean []vis=new boolean[n];
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.x!=b.x?a.x-b.x:a.y-b.y);
        long sum=0;
        for(i=0;i<n;i++)
        {
            sum+=nums[i];
            pq.offer(new pair(nums[i],i));
        }
        for(i=0;i<q;i++)
        {
            int a = queries[i][0];
            int b = queries[i][1];
            if(!vis[a]) {
                vis[a] = true;
                sum-=nums[a];
            }
            while(pq.size()>0) {
                if(b==0)
                    break;
                pair top = pq.poll();
                if(vis[top.y])
                    continue;
                vis[top.y]=true;
                sum-=nums[top.y];
                b--;
            }
            ans[i]=sum;
        }
        return ans;
    }
}