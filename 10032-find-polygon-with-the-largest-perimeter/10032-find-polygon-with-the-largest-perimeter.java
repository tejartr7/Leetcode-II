class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum=0;
        long maxi=0;
        long ans=-1;
        for(int x:nums)
        {
            maxi=Math.max(maxi,x);
            sum+=x;
            if(sum-maxi>maxi)
            {
                ans=Math.max(ans,sum);
            }
        }
        return ans;
    }
}