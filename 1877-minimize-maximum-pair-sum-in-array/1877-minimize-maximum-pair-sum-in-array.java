class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        int ans=0;
        while(i<j)
        {
            int sum=nums[i]+nums[j];
            ans=Math.max(ans,sum);
            i++;
            j--;
        }
        return ans;
    }
}