class Solution {
    public int[] fullBloomFlowers(int[][] a, int[] p) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        int i,j,m=a.length,n=p.length;
        int[] ans=new int[n];
       // Arrays.fill(ans,-1);
        for(i=0;i<m;i++)
        {
            int x=a[i][0];
            int y=a[i][1];
            map.put(x,map.getOrDefault(x,0)+1);
            map.put(y+1,map.getOrDefault(y+1,0)-1);
        }
        int sum=0;
        for(int x:map.keySet())
        {
            sum+=map.get(x);
            map.put(x,sum);
        }
        for(i=0;i<n;i++)
        {
            int k=map.floorKey(p[i])==null?-1:map.floorKey(p[i]);
            if(k!=-1)
                ans[i]=map.get(k);
        }
        return ans;
    }
}