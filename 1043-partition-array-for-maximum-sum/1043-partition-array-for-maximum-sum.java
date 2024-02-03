class Solution {
    int dp[][];
    
    public int helper(int prev, int idx, int[] arr, int k) {
        int n = arr.length;
        
        if (idx >= n)
            return 0;

        if (dp[prev][idx] != -1)
            return dp[prev][idx];

        int not = 0, take = 0;

        if (idx - prev + 1 == k) {
            int maxi = 0;

            // Find the maximum element in the current partition
            for (int i = prev; i <= idx; i++)
                maxi = Math.max(maxi, arr[i]);

            // Calculate the sum by taking the maximum element in the partition multiplied by k
            take = maxi * k + helper(idx + 1, idx + 1, arr, k);
        } else if (idx - prev + 1 < k) {
            int maxi = 0;

            // Find the maximum element in the current partition
            for (int i = prev; i <= idx; i++)
                maxi = Math.max(maxi, arr[i]);

            // Calculate the sum by taking the maximum element in the partition multiplied by the partition size
            take = maxi * (idx - prev + 1) + helper(idx + 1, idx + 1, arr, k);

            // Calculate the sum without taking the current partition
            not = helper(prev, idx + 1, arr, k);
        }

        // Return the maximum sum between including and excluding the current partition
        return dp[prev][idx] = Math.max(take, not);
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        dp = new int[n][n];
        
        // Initialize dp array with -1
        for (int x[] : dp)
            Arrays.fill(x, -1);

        return helper(0, 0, arr, k);
    }
}
