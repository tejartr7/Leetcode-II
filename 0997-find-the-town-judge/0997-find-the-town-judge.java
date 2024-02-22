class Solution {
    public int findJudge(int l, int[][] trust) {
        int a[]=new int[l+1];
        int i,n=trust.length;
        Arrays.fill(a,0);
        Map<Integer,Integer> map=new HashMap<>();
        for(i=0;i<n;i++)
        {
            a[trust[i][1]]++;
            map.put(trust[i][0],trust[i][1]);
        }
        int ans=-1;
        for(i=1;i<=l;i++)
        {
            if(a[i]==l-1)
            {
                ans=i;
            }
        }
        return map.containsKey(ans)?-1:ans;
    }
}