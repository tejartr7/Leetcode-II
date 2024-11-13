class Solution {
    public long binarySearch1(int[] nums, int currentValue, int index, int lower, int upper) {
        int start = index + 1;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > (upper - currentValue)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    public long binarySearch2(int[] nums, int currentValue, int index, int lower, int upper) {
        int start = index + 1;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < (lower - currentValue)) {
                start= mid+1;
            } else {
                 end= mid;
            }
        }
        return start;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int i,n=nums.length;
        long ans=0;
        for(i=0;i<n;i++)
        {
            ans+=binarySearch1(nums,nums[i],i,lower,upper)-binarySearch2(nums,nums[i],i,lower,upper);
        }
         return ans;
    }
}