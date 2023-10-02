class Solution {
    int cnt;
    Map<Integer,List<Integer>> map;
    public long helper(int node,int par,int k,int[] arr)
    {
        long sum=0;
        for(int x:map.get(node))
        {
            if(x==par)
                continue;
            sum+=helper(x,node,k,arr);
        }
        sum+=arr[node];
        if(sum%k==0)
            cnt++;
        return sum;
    }
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        cnt=0;
        map=new HashMap<>();
        int i,j,m=edges.length;
        for(i=0;i<n;i++)
            map.put(i,new ArrayList<>());
        for(i=0;i<m;i++)
        {
            int x=edges[i][0];
            int y=edges[i][1];
            map.get(x).add(y);
            map.get(y).add(x);
        }
        //System.out.println(map);
        helper(0,-1,k,values);
        return cnt;
    }
}