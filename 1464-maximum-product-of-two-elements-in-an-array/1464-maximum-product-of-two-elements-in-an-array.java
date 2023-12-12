class Solution {
    public int maxProduct(int[] nums) {
        int i,j,n=nums.length;
        int maxi=Integer.MIN_VALUE;
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                if(j!=i)
                {
                    maxi=Math.max(maxi,(nums[i]-1)*(nums[j]-1));
                }
            }
        }
        return maxi;
    }
}