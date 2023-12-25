class Solution {
    int dp[];
    public int helper(int idx,char[] ch)
    {
        int i,j,n=ch.length;
        if(idx>=n)
            return 1;
        int x=0;
        if(dp[idx]!=-1)
            return dp[idx];
        if(ch[idx]!='0')
            x=helper(idx+1,ch);
        int y=0;
        int k=(ch[idx]-'0')*10;
        if(idx+1<n && k!=0)
            k+=ch[idx+1]-'0';
        if(k>=1 && k<=26 && idx+1<n)
        {
            y=helper(idx+2,ch);
        }
       // System.out.println(idx+" "+x+" "+y);
        return dp[idx]=x+y;
    }
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')
            return 0;
        dp=new int[s.length()+1];
        Arrays.fill(dp,-1);
        return helper(0,s.toCharArray());
    }
}