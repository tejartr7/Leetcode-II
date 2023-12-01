class Solution {
    int dp[];
    public boolean helper(int idx,String s,Set<String> set)
    {
        if(idx>=s.length())
            return true;
        if(dp[idx]!=-1)
            return dp[idx]==1;
        String temp="";
        for(int j=idx;j<s.length();j++)
        {
            temp+=s.charAt(j);
            if(set.contains(temp))
            {
                if(helper(j+1,s,set))
                {
                    dp[idx]=1;
                    return true;
                }
            }
        }
        dp[idx]=0;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int i,j,n=s.length();
        Set<String> set=new HashSet<>();
        for(String x:wordDict)
            set.add(x);
        dp=new int[301];
        Arrays.fill(dp,-1);
        return helper(0,s,set);
    }
}