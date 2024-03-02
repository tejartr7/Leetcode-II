class Solution {
    public int[] sortedSquares(int[] nums) {
     int i=0;
        int n=nums.length;
        int j=n-1;
        int ans[]=new int[n];
        while(i<=j)
        {
            if(Math.abs(nums[i])>Math.abs(nums[j]))
            {
                ans[n-1]=nums[i]*nums[i];
                i++;
            }
            else
            {
                ans[n-1]=nums[j]*nums[j];
                j--;
            }
            n--;
        }
        return ans;
    }
}