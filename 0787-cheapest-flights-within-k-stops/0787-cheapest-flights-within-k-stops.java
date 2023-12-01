//striver baba
class pair
{
    int node;
    int weight;
    pair(int node,int weight)
    {
        this.node=node;
        this.weight=weight;
    }
}
class tuple{
    int stops;
    int node;
    int dis;
    tuple(int x,int y,int z)
    {
        stops=x;
        node=y;
        dis=z;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<pair>> map=new HashMap<>();
        int i;
        int l=flights.length;
        for(i=0;i<n;i++)
        {
            map.put(i,new ArrayList<>());
        }
        for(i=0;i<l;i++)
        {
            map.get(flights[i][0]).add(new pair(flights[i][1],flights[i][2]));
        }
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        Queue<tuple>q =new LinkedList<>();
        q.offer(new tuple(0,src,0));
        while(!q.isEmpty())
        {
            tuple top=q.poll();
            int stop=top.stops;
            int node=top.node;
            int dis=top.dis;
            if(stop>k)
                continue;
            for(pair x:map.get(node))
            {
                int a=x.node;
                int b=x.weight;
                if(b+dis<dist[a])
                {
                    dist[a]=b+dis;
                    q.offer(new tuple(stop+1,a,b+dis));
                }
            }
        }
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}