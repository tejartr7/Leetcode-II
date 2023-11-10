class Solution {
    Map<Integer,List<Integer>> map;
    int[] ans;
    boolean vis[];
    Set<Integer> seen;
    public void dfs(int idx,int x,int[] ans)
    {
        if(seen.contains(x) || idx>=ans.length)
            return ;
        seen.add(x);
        ans[idx]=x;
        for(int val:map.get(x))
        {
            if(!seen.contains(val))
            {
                dfs(++idx,val,ans);
            }
        }
    }
    public int[] restoreArray(int[][] adj) {
        map=new HashMap<>();
        int i,j;
        int n=adj.length;
        seen=new HashSet<>();
        for(i=0;i<n;i++)
        {
            int x=adj[i][0];
            int y=adj[i][1];
            if(!map.containsKey(x))
                map.put(x,new ArrayList<>());
            if(!map.containsKey(y))
                map.put(y,new ArrayList<>());
            map.get(x).add(y);
            map.get(y).add(x);
        }
        ans=new int[n+1];
        for(int x:map.keySet())
        {
            if(map.get(x).size()==1)
            {
                dfs(0,x,ans);
            }
        }
        return ans;
    }
}