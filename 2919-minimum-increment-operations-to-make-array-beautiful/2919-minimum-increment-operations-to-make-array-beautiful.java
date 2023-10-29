class Solution {
    long[] dp;

    public long helper(int idx, int[] nums, int k) {
        if (idx + 2 >= nums.length)
            return 0L;

        if (dp[idx] != -1)
            return dp[idx];

        long minOperations = Long.MAX_VALUE;

        long x = 0, y = 0, z = 0;
        x=Math.max(0,k-nums[idx])+helper(idx+1,nums,k);
        y=Math.max(0,k-nums[idx+1])+helper(idx+2,nums,k);
        z=Math.max(0,k-nums[idx+2])+helper(idx+3,nums,k);
        return dp[idx] = Math.min(x,Math.min(y,z));
    }

    public long minIncrementOperations(int[] nums, int k) {
        dp = new long[nums.length];
        Arrays.fill(dp, -1);
        if (nums.length == 3) {
            int maxi = Math.max(nums[0], Math.max(nums[1], nums[2]));
            return (long) Math.max(k - maxi, 0);
        }
        return helper(0, nums, k);
    }
}
