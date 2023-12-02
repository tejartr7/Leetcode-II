class Solution {
    int dp[][];
    public int helper(int i,int j,String s,String t)
    {
        int m=s.length(),n=t.length();
        if(j>=n)
            return 1;
        if(i>=m)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int a=helper(i+1,j,s,t);
        if(s.charAt(i)==t.charAt(j))
        {
            a+=helper(i+1,j+1,s,t);
            //a+=helper(i+1,j,s,t);
        }
        return dp[i][j]=a;
    }
    public int numDistinct(String s, String t) {
        dp=new int[s.length()][t.length()];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        return helper(0,0,s,t);
    }
}