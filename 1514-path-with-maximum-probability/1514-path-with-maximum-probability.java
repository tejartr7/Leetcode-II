class pair
{
    int node;
    double val;
   pair(int a, double b) {
    node = a;
    val = b;
}
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        Map<Integer,List<pair>> map=new HashMap<>();
        int i,j,l=succProb.length;
        double ans=0.00d;
        for(i=0;i<n;i++)
            map.put(i,new ArrayList<>());
        for(i=0;i<l;i++)
        {
            int x=edges[i][0];
            int y=edges[i][1];
            double z=succProb[i];
            map.get(x).add(new pair(y, z));
            map.get(y).add(new pair(x, z));
        }
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.val, a.val));

        pq.offer(new pair(start,1.000000d));
        double dp[]=new double[n];
        Arrays.fill(dp,Double.MIN_VALUE);
        dp[start]=1d;
        while(!pq.isEmpty())
        {
            pair top=pq.poll();
            int node=top.node;
            double val=top.val;
            if(node==end)
                return val;
            for(pair x:map.get(node))
            {
                //System.out.println(node+" "+x.node+" "+dp[x.node]+" "+(x.val*val));
                if(dp[x.node]<x.val*val)
                {
                    dp[x.node]=x.val*val;
                    pq.offer(new pair(x.node,dp[x.node]));
                }
            }
        }
        return 0d;
    }
}