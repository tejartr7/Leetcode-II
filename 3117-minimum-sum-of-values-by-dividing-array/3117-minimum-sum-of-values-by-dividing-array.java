class Solution {
    Map<Integer,Integer>[][]dp;
    public int helper(int i,int j,int curr,int nums[],int and[]){
        int m=nums.length,n=and.length;
        if(i>=m){
            if(j>=n){
                return 0;
            }
            return 1000_000_000;
        }
        if(j>=n){
            return 1000_000_000;
        }
        if(dp[i][j]!=null && dp[i][j].containsKey(curr)) return dp[i][j].get(curr);
        int take=1000_000_000;
        if((curr&nums[i])==and[j]){
            take=nums[i]+helper(i+1,j+1,((1<<17)-1),nums,and);
        }
        int notTake=helper(i+1,j,(curr&nums[i]),nums,and);
        int mini=Math.min(take,notTake);
        if(dp[i][j]==null)dp[i][j]=new HashMap<>();
        dp[i][j].put(curr,mini);
        return mini;
    }
    public int minimumValueSum(int[] nums, int[] andValues) {
        dp = new HashMap[nums.length+1][11];
        int x=helper(0,0,((1<<17)-1),nums,andValues);
        return x>=1000_000_000?-1:x;
    }
}