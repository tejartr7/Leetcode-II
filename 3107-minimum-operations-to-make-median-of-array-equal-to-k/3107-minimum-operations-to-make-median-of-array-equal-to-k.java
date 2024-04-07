class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int i,j,n=nums.length;
        long ans = 0;
        if(n%2==0)
        {
            int mid = nums[n/2];
            if(mid==k)
                return 0;
            else if(mid>k)
            {
                for(i=n/2;i>=0;i--)
                {
                    if(nums[i]>k)
                    ans+=nums[i]-k;
                }
            }
            else{
                for(i=n/2;i<n;i++)
                {
                    if(nums[i]<k)
                        ans+=k-nums[i];
                }
            }
        }
        else{
            int mid=nums[n/2];
            if(mid==k)
                return 0;
            else if(mid>k)
            {
                for(i=n/2;i>=0;i--)
                {
                    if(nums[i]>k)
                    ans+=nums[i]-k;
                }
            }
            else{
                for(i=n/2;i<n;i++)
                {
                    if(nums[i]<k)
                        ans+=k-nums[i];
                }
            }
        }
        return ans;
    }
}