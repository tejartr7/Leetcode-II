class Solution {
    long dp[][][];
    public long helper(int idx,int taken,int cool,int a[],int []b){
        int i,j,n=a.length;
        if(idx>=n) return 0;
        if(dp[idx][taken][cool]!=-1) return dp[idx][taken][cool];
        long x=0;
        if(cool==1){
            return helper(idx+1,taken,0,a,b);
        }
        if(taken==1){
            x=a[idx]+helper(idx+1,1,0,a,b);
            x=Math.max(x,a[idx]+helper(idx+1,0,1,a,b));
        }
        else {
            x=Math.max(x,b[idx]+helper(idx+1,0,0,a,b));
            x=Math.max(x,b[idx]+helper(idx+1,1,1,a,b));
        }
        return dp[idx][taken][cool]=x;
    }
    public long maxEnergyBoost(int[] a, int[] b) {
        long sum1=0,sum2=0;
        int i,j,n=a.length;
        dp=new long[n+1][2][2];
        for(long x[][]:dp){
            for(long y[]:x){
                Arrays.fill(y,-1);
            }
        }
        for(int x:a) sum1+=x;
        for(int x:b) sum2+=x;
        long ans=Math.max(sum1,sum2);
        long x=Math.max(helper(0,1,0,a,b),helper(0,0,0,a,b));
        return Math.max(ans,x);
    }
}