class Solution {
    public int minimumTime(int n, int[][] r, int[] time) {
        Queue<Integer> q=new LinkedList<>();
        int i,j;
        //n=time.length;
        int[] indegree=new int[n+1];
        int[] dist=new int[n+1];
        Map<Integer,Set<Integer>> map=new HashMap<>();
        for(i=1;i<=n;i++)
            map.put(i,new HashSet<>());
        for(int x[]:r)
        {
            map.get(x[0]).add(x[1]);
            indegree[x[1]]++;
        }
        for(i=1;i<=n;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
                dist[i]=time[i-1];
            }
        }
        int ans=0;
        while(q.size()>0)
        {
            int node=q.poll();
            for(int x:map.get(node))
            {
                dist[x]=Math.max(dist[x],dist[node]+time[x-1]);
                indegree[x]--;
                if(indegree[x]==0)
                    q.offer(x);
            }
        }
        for(i=1;i<=n;i++)
            ans=Math.max(ans,dist[i]);
        return ans;
    }
}