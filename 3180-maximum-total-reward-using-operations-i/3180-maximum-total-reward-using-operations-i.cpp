#include <vector>
#include <algorithm>
#include <cstring> // For memset

class Solution {
    int dp[2001][4005]; // Equivalent to the 2D array in the Java solution

public:
    int helper(int x, int idx, std::vector<int>& nums) {
        int n = nums.size();
        if (idx == n) return x;
        if (dp[idx][x] != -1) return dp[idx][x];

        int notTake = helper(x, idx + 1, nums);
        int take = 0;
        if (x < nums[idx]) {
            take = helper(x + nums[idx], idx + 1, nums);
        }
        return dp[idx][x] = std::max(take, notTake);
    }

    int maxTotalReward(std::vector<int>& rewardValues) {
        std::sort(rewardValues.begin(), rewardValues.end());
        std::memset(dp, -1, sizeof(dp));
        return helper(0, 0, rewardValues);
    }
};
