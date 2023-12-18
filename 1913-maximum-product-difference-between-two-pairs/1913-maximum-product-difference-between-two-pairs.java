class Solution {
    public int maxProductDifference(int[] nums) {
       int l=nums.length;
        Arrays.sort(nums);
        int p1=nums[0]*nums[1];
        int p2=nums[l-1]*nums[l-2];
        return p2-p1;
    }
}