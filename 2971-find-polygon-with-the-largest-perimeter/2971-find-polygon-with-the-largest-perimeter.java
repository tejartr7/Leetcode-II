class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int i,j,n=nums.length;
        long maxi=-1;
        long sum=0;
        for(i=0;i<n;i++)
        {
            if(i>=2)
            {
                if(((long)nums[i])<sum)
                {
                    maxi=Math.max(maxi,sum+nums[i]);
                }
            }
            sum+=nums[i];
        }
        return maxi;
    }
}