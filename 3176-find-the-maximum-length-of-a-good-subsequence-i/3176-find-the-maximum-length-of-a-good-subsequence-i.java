class Solution {
    int dp[][][];
    int maxi=0;
    public int helper(int idx,int []nums,int k,int cnt[],int prev){
        int i,j,n=nums.length;
        if(idx>=n){
            return 0;
        }
        if(dp[idx][cnt[0]][prev+1]!=-1)
            return dp[idx][cnt[0]][prev+1];
        int notTake=helper(idx+1,nums,k,cnt,prev);
        int take=0;
        if(prev!=-1){
            if(nums[prev]==nums[idx]){
              take=Math.max(take,1+helper(idx+1,nums,k,cnt,idx));  
            }
            else{
                if(k>cnt[0]){
                    cnt[0]+=1;
                    take=Math.max(take,1+helper(idx+1,nums,k,cnt,idx));
                    cnt[0]-=1;
                }
            }
        }else{
            take=Math.max(take,1+helper(idx+1,nums,k,cnt,idx));
        }
        return dp[idx][cnt[0]][prev+1]=Math.max(take,notTake);
    }
    public int maximumLength(int[] nums, int k) {
        int i,j,n=nums.length;
        dp=new int[n+1][k+1][n+1];
        for(int x[][]:dp){
            for(int y[]:x){
                Arrays.fill(y,-1);
            }
        }
        return helper(0,nums,k,new int[1],-1);     
    }
}