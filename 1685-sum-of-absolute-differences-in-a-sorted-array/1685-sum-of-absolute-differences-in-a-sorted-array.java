class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int i,j,n=nums.length;
        int[] pre=new int[n];
        int[] ans=new int[n];
        int sum=0;
        for(int x:nums)
            sum+=x;
        for(i=0;i<n;i++)
        {
            if(i>0)
            ans[i]+=Math.abs(pre[i-1]-(i*nums[i]));
            ans[i]+=Math.abs(sum-(nums[i]*(n-i)));
            sum-=nums[i];
            pre[i]+=nums[i];
            if(i>0)
            pre[i]+=pre[i-1];
       //     System.out.println(pre[i]+" "+sum);
        }
        return ans;
    }
}