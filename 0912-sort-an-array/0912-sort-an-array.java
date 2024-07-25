class Solution {
    void swap(int nums[],int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    void heapify(int nums[],int n,int i)
    {
        int index=i;
        int left=2*i+1;
        int right=2*i+2;
        if(left<n && nums[left]>nums[index])
        {
            index=left;
        }
        if(right<n && nums[right]>nums[index])
        {
            index=right;
        }
        if(index!=i)
        {
            swap(nums,i,index);
            heapify(nums,n,index);
        }
    }
    public int[] sortArray(int[] nums) {
        int i,n=nums.length;
        for(i=n/2;i>=0;i--)
        {
            heapify(nums,n,i);
        }
        for(i=n-1;i>=0;i--)
        {
            swap(nums,i,0);
            heapify(nums,i,0);
        }
        return nums;
    }
}