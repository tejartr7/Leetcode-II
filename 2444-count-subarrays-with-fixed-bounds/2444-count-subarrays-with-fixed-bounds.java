class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long count=0;
        int mini=-1,max=-1,left=-1;
        int i,n=nums.length;
        for(i=0;i<n;i++)
        {
            if(nums[i]<minK|| nums[i]>maxK)
            {
                left=i;
            }
            if(nums[i]==minK)
                mini=i;
            if(nums[i]==maxK)
                max=i;
            count+=Math.max(0,Math.min(mini,max)-left);
        }
        return count;
    }
}