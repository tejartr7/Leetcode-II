class Solution {
   int[] dp;
   public int helper(int target, int[] nums) {
       // base condition
       if (target == 0)
           return 1;
       if (target < 0)
           return 0;
       if (dp[target] != -1)
           return dp[target];
       int res = 0;
       for (int i = 0; i < nums.length; i++) {
           res += helper(target - nums[i], nums);
       }
       dp[target] = res;
       return res;
   }

   public int combinationSum4(int[] nums, int target) {
       dp = new int[target + 1];
       Arrays.fill(dp, -1);
       if (target == 0)
           return 1;
       return helper(target, nums);
   }
}
