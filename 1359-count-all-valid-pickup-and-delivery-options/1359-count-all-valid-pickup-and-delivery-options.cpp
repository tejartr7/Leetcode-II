class Solution {
public:
    int countOrders(int n) {
        long long dp[n+3];
        long long mod=1000000007;
        if(n==1)
            return 1;
        if(n==2)
            return 6;
        if(n==3)
            return 90;
        dp[0]=dp[1]=1l;
        dp[2]=6l;
        dp[3]=90l;
        int i;
        long long prev=15;
        for(i=4;i<=n;i++)
        {
            
            dp[i]=(dp[i-1]%mod*(prev+9+(4*(i-3)))%mod)%mod;
            dp[i]%=mod;
           // System.out.print(dp[i]+" ");
            prev=prev+9+(4*(i-3));
            
        }
        return int(dp[n]%mod);
    }
};