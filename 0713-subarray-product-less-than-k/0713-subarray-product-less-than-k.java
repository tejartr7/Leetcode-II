class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int pro=1;
        int i,j,n=nums.length;
        if(k<=1) return 0;
        i=0;j=0;
        int ans=0;
        while(j<n)
        {
            pro*=nums[j];
            while(pro>=k)
            {
                pro/=nums[i];
                i++;
            }
            if(pro<k)
            ans+=j-i+1;
            j++;
        }
        return ans;
    }
}