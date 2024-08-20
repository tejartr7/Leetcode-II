class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];
        
        // Compute suffix sums
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = piles[i] + suffixSum[i + 1];
        }
        
        // Memoization table
        int[][] dp = new int[n][n + 1];  // dp[i][m] = max stones Alice can collect starting from index i with M = m
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        // Recursively solve with memoization
        return helper(0, 1, piles, suffixSum, dp);
    }
    
    private int helper(int idx, int M, int[] piles, int[] suffixSum, int[][] dp) {
        int n = piles.length;
        
        // If we are at the last pile, take all remaining stones
        if (idx >= n) {
            return 0;
        }
        
        // If we have already computed this state, return the result
        if (dp[idx][M] != -1) {
            return dp[idx][M];
        }
        
        // If Alice can take all remaining stones
        if (idx + 2 * M >= n) {
            return suffixSum[idx];
        }
        
        int maxStones = 0;
        
        // Try taking X piles where 1 <= X <= 2M
        for (int X = 1; X <= 2 * M; X++) {
            // Calculate the maximum stones Alice can get if she takes X piles
            int currentStones = suffixSum[idx] - helper(idx + X, Math.max(M, X), piles, suffixSum, dp);
            maxStones = Math.max(maxStones, currentStones);
        }
        
        // Store the result in the memoization table
        dp[idx][M] = maxStones;
        return dp[idx][M];
    }
}