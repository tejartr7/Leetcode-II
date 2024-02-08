class Solution {
    int dp[];
    public int numSquares(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,1000_000_000);
        List<Integer> list=new ArrayList<>();
        int i,j;
        for(i=1;i<=100;i++)
        {
            list.add(i*i);
            if(i*i<=n)
            dp[i*i]=1;
        }
        for(i=2;i<=n;i++)
        {
            for(int x:list)
            {
                if(x>i)
                    break;
                //System.out.println(dp[i]);
                dp[i]=Math.min(1+dp[i-x],dp[i]);
            }
        }
        return dp[n];
    }
}