class Solution {
    public boolean dfs(int start,int des,boolean visited[],Map<Integer,List<Integer>> adj)
    {
        visited[start]=true;
        for(int x:adj.get(start))
        {
            if(x==des)
                return true;
            else if(!visited[x])
            {
                if(dfs(x,des,visited,adj))
                    return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean visited[]=new boolean[n];
        Map<Integer,List<Integer>> adj=new HashMap<>();
        int i;
        if(source==destination)
            return true;
        for(i=0;i<n;i++)
            adj.put(i,new ArrayList<>());
        for(int x[]:edges)
        {
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }
        //System.out.println(adj);
        return dfs(source,destination,visited,adj);
    }
}