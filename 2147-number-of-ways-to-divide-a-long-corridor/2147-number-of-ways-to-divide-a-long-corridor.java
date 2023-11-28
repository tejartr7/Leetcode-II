class Solution {
    long ans = 0;
    long mod = 1000000007L;

    public int numberOfWays(String s) {
        ans=1l;
        int i,j,n=s.length();
        List<Integer> list=new ArrayList<>();
        for(i=0;i<n;i++)
        {
            if(s.charAt(i)=='S')
            list.add(i);
        }
        if(list.size()%2==1 || list.size()==0)
            return 0;
        for(i=1;i<list.size()-1;i+=2)
        {
            ans=(ans*(long)(list.get(i+1)-list.get(i)))%mod;
        }
        return (int)(ans%mod);
    }

    public long helper(int idx, int prev, String s, int[] cnt, Long[] memo) {
        if (idx == cnt.length - 1) {
            int temp = cnt[cnt.length - 1];
            if (prev > 0)
                temp -= cnt[prev - 1];
            return temp == 2 ? 1L : 0L;
        }

        if (memo[prev] != null) {
            return memo[prev];
        }

        long x = helper(idx + 1, prev, s, cnt, memo);
        long y = 0;
        int temp = cnt[idx];
        if (prev > 0)
            temp -= cnt[prev - 1];
        if (temp == 2)
            y = helper(idx + 1, idx, s, cnt, memo);

        memo[prev] = (x + y) % mod;
        return memo[prev];
    }
}
