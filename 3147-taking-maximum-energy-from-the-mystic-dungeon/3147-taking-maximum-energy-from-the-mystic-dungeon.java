class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int i,j,n=energy.length;
        int dp[]=new int[n+1];
        int ans=Integer.MIN_VALUE;
        List<Integer> list=new ArrayList<>();
        int sum=0;
        for(i=n-1;i>=n-k;i--){
            for(j=i;j>=0;j-=k){
                sum+=energy[j];
                //System.out.println(sum);
                ans=Math.max(ans,sum);
            }
            sum=0;
        }
        return ans;
    }
}