class Solution {
    public int longestSubarray(int[] nums) {
        int i,j,n=nums.length;
        int maxi=-1;
        for(int x:nums) maxi=Math.max(maxi,x);
        int ans=0,cnt=0;
        for(i=0;i<n;i++){
            if(nums[i]==maxi) cnt++;
            else cnt=0;
            ans=Math.max(ans,cnt);
        }
        return ans;
    }
}