class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int i,j,n=nums.length;
        Arrays.sort(nums);
        int max=0;
        int index=-1;
        int dp[]=new int[n];
        int pre[]=new int[n];
        Arrays.fill(dp,1);
        for(i=0;i<n;i++)
        {
            pre[i]=-1;
            for(j=i-1;j>=0;j--)
            {
                if(nums[i]%nums[j]==0){
                    if(1+dp[j]>dp[i])
                    {
                        dp[i]=dp[j]+1;
                        pre[i]=j;
                    }
                }
            }
            if(dp[i]>max)
            {
                max=dp[i];
                index=i;
            }
        }
        while(index!=-1)
        {
            list.add(nums[index]);
            index=pre[index];
        }
        return list;
    }
}