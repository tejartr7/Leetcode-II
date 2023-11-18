class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i,j,n=nums.length;
        int ans=0;
        i=0;
        j=0;
        int sum=0;
        while(j<n)
        {
            sum+=nums[j];
            while((nums[j]*(j-i+1))-sum>k)
            {
                sum-=nums[i];
                i++;
            }
            ans=Math.max(ans,j-i+1);
            j++;
        }
        return ans;
    }
}