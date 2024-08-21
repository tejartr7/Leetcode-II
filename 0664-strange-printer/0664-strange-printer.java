class Solution {
    int dp[][];
    public int helper(int l,int r,String s){
        if(l>r) return 0;
        if(l==r) return 1;
        if(dp[l][r]!=-1) return dp[l][r];
        int ans=1+helper(l+1,r,s);
        for(int i=l+1;i<=r;i++){
            if(s.charAt(l)==s.charAt(i)){
                ans=Math.min(ans,helper(l,i-1,s)+helper(i+1,r,s));
            }
        }
        return dp[l][r]=ans;
    }
    public int strangePrinter(String s) {
        int n=s.length();
        dp=new int[n][n];
        for(int x[]:dp) Arrays.fill(x,-1);
        return helper(0,n-1,s);
    }
}