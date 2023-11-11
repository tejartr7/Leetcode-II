class pair
{
    int node;
    int wt;
    pair(int x,int y)
    {
        node=x;
        wt=y;
    }
}
class Graph {
    Map<Integer,List<pair>> map;
    public Graph(int n, int[][] edges) {
        map=new HashMap<>();
        int i,j;
        for(i=0;i<=100;i++)
            map.put(i,new ArrayList<>());
        for(i=0;i<edges.length;i++)
        {
            int x=edges[i][0];
            int y=edges[i][1];
            int z=edges[i][2];
            map.get(x).add(new pair(y,z));
        }
    }
    
    public void addEdge(int[] edges) {
        int x=edges[0];
        int y=edges[1];
        int z=edges[2];
        if(!map.containsKey(x))
                map.put(x,new ArrayList<>());
        map.get(x).add(new pair(y,z));
    }
    
    public int shortestPath(int node1, int node2) {
         int i,j,n=map.size();
         boolean vis[]=new boolean[n];
         int dis[]=new int[101];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[node1]=0;
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.wt-b.wt);
        pq.offer(new pair(node1,0));
        while(pq.size()>0)
        {
            pair top=pq.poll();
            int node=top.node;
            int wt=top.wt;
            for(pair x:map.get(node))
            {
                if(dis[x.node]>x.wt+dis[node])
                {
                    dis[x.node]=x.wt+dis[node];
                    pq.offer(new pair(x.node,dis[x.node]));
                }
            }
        }
        return dis[node2]==Integer.MAX_VALUE?-1:dis[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */