class Solution {
     public int numberOfGoodPartitions(int[] a) {
         int res = 1, n = a.length, mod = 1000000007;
         Map<Integer,Integer> map=new HashMap<>();
         int i,j=0;
         for(i=0;i<n;i++)
         {
             map.put(a[i],i);
         }
         for(i=0;i<n;i++)
         {
             if(i>j)
             {
                 res=(res*2)%mod;
             }
             j=Math.max(j,map.get(a[i]));
         }
         return res;
    }
}