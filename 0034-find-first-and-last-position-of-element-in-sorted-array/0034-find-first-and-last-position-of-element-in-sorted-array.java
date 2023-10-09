class Solution {
    public int bsf(int nums[],int target)
    {
        int i=0,j=nums.length-1;
        boolean found=false;
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            if(target==nums[mid])
                found=true;
            if(target<=nums[mid])
            {
                j=mid-1;
            }
            else
                i=mid+1;
        }
        return found?i:-1;
    }
    public int bsc(int nums[],int target)
    {
        int i=0,j=nums.length-1;
        boolean found=false;
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            if(target==nums[mid])
                found=true;
            if(target>=nums[mid])
            {
                i=mid+1;
            }
            else
                j=mid-1;
        }
        return found?i-1:-1;
    }
    public int[] searchRange(int[] nums, int target) {
        int a[]=new int[2];
        a[0]=bsf(nums,target);
        a[1]=bsc(nums,target);
        return a;
    }
}