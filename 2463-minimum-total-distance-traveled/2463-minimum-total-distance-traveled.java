class Solution {
    long dp[][][];
    List<Integer> robot;
    int factory[][];
    int m,n;
    public long helper(int i,int j){
        if(i>=m) return 0;
        if(j>=n) return 10000_0000_0000L;
        long ans=10000_0000_0000L;
        long notAssign=helper(i,j+1);
        long assign=10000_0000_0000L;
        if(dp[i][j][factory[j][1]]!=-1) return dp[i][j][factory[j][1]];
        if(factory[j][1]>0){
            factory[j][1]-=1;
            ans=Math.min(ans,Math.abs(robot.get(i)-factory[j][0])+helper(i+1,j));
            factory[j][1]+=1;
        }
        ans=Math.min(ans,notAssign);
        return dp[i][j][factory[j][1]]=ans;
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        this.robot=robot;
        this.factory=factory;
        m=robot.size();
        n=factory.length;
        dp=new long[m+1][n+1][101];
        for(long x[][]:dp)
        {
            for(long y[]:x){
                Arrays.fill(y,-1L);
            }
        }
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->a[0]-b[0]);
        return helper(0,0);
    }
}