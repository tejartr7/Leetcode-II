class Solution {
    public int missingNumber(int[] nums) {
        int i,j,n=nums.length;
        int x=0;
        for(int xx:nums)
            x^=xx;
        for(i=0;i<=n;i++)
            x^=i;
        return x;
    }
}