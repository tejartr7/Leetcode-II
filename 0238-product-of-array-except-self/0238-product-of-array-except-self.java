class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int i;
        int res[]=new int[n];
        res[0]=nums[0];
        for(i=1;i<n;i++)
        {
            res[i]=res[i-1]*nums[i];
        }
        int pro=nums[n-1];
        res[n-1]=res[n-2];
        for(i=n-2;i>0;i--)
        {
            res[i]=res[i-1]*pro;
            pro*=nums[i];
        }
        res[0]=pro;
        return res;
        
    }
}