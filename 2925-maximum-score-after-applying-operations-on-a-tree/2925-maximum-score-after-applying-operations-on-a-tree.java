class Solution {
    Map<Integer,List<Integer>> map;
    public long helper(int x,int par,int[] val)
    {
        if(map.get(x).size()==0)
            return (long)val[x];
        long sum=0;
        for(int i:map.get(x))
        {
            if(i==par)
                continue;
            sum+=helper(i,x,val);
        }
        if(sum==0l)
            return (long)val[x];
        return Math.min(sum,1l*val[x]);
    }
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        long sum=0;
        int i,j,m=edges.length;
        int n=values.length;
        map=new HashMap<>();
        for(i=0;i<n;i++)
            map.put(i,new ArrayList<>());
        
        for(i=0;i<m;i++)
        {
            int x=edges[i][0];
            int y=edges[i][1];
            map.get(x).add(y);
            map.get(y).add(x);
        }
        for(int x:values)
            sum+=x;
        return sum-helper(0,-1,values);
    }
}