class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        long[][] dp = new long[n + 1][2];
        dp[n][1] = 0;
        dp[n][0] = Integer.MIN_VALUE;
        
        for (int index = n - 1; index >= 0; index--) {
            for (int isEven = 0; isEven <= 1; isEven++) {
                // Case 1: we perform the operation on this element.
                long performOperation = dp[index + 1][isEven ^ 1] + (nums[index] ^ k);
                // Case 2: we don't perform operation on this element.
                long dontPerformOperation = dp[index + 1][isEven] + nums[index];

                dp[index][isEven] = Math.max(performOperation, dontPerformOperation);
            }
        }
        
        return dp[0][1];
    }
}