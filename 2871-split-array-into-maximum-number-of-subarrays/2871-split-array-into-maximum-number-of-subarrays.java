class Solution {
    public int maxSubarrays(int[] nums) {
        int cnt=0;
        int val=Integer.MAX_VALUE;
        for(int x:nums)
        {
            val&=x;
            if(val==0)
            {
                cnt++;
                val=Integer.MAX_VALUE;
            }
        }
        return Math.max(cnt,1);
    }
}