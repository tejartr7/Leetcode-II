class Solution {
    int dp[][];
    public int helper(int prev,int idx,int[] arr,int k)
    {
        int i,j,n=arr.length;
        if(idx>=n)
            return 0;
        int not=0,take=0;
        if(dp[prev][idx]!=-1)
            return dp[prev][idx];
        if(idx-prev+1==k)
        {
            int maxi=0;
            for(i=prev;i<=idx;i++)
                maxi=Math.max(maxi,arr[i]);
            take=maxi*k+helper(idx+1,idx+1,arr,k);
        }
        else if(idx-prev+1<k){
            int maxi=0;
            for(i=prev;i<=idx;i++)
                maxi=Math.max(maxi,arr[i]);
            take=(maxi*(idx-prev+1))+helper(idx+1,idx+1,arr,k);
            not=helper(prev,idx+1,arr,k);
        }
        return dp[prev][idx]=Math.max(take,not);
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp=new int[501][501];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        return helper(0,0,arr,k);
    }
}