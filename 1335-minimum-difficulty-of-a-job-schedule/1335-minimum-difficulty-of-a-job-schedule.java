class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (n < d) {
            return -1; // Cannot complete in d days
        }

        int[][] dp = new int[n][d + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(0, d, jobDifficulty, dp);
    }

    private int helper(int idx, int d, int[] jobDifficulty, int[][] dp) {
        if (idx == jobDifficulty.length) {
            return (d == 0) ? 0 : Integer.MAX_VALUE; // Return 0 if all jobs are completed
        }
        if(d<0)
            return Integer.MAX_VALUE; 
        if (dp[idx][d] != -1) {
            return dp[idx][d];
        }

        int maxDifficulty = jobDifficulty[idx];
        int result = Integer.MAX_VALUE;

        for (int i = idx; i < jobDifficulty.length; i++) {
            maxDifficulty = Math.max(maxDifficulty, jobDifficulty[i]);

            int remainingDifficulty = helper(i + 1, d - 1, jobDifficulty, dp);
            if (remainingDifficulty != Integer.MAX_VALUE) {
                result = Math.min(result, maxDifficulty + remainingDifficulty);
            }
        }

        dp[idx][d] = result;
        return result;
    }
}
