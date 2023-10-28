class Solution {
    public int countVowelPermutation(int n) {
        final int MOD = 1000000007;
        long[][] dp = new long[n + 1][5];

        // Initialize the base case with 1 for each vowel
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            // 'a' can follow 'e', 'i', or 'u'
            dp[i][0] = (dp[i - 1][1]) % MOD;
            // 'e' can follow 'a' or 'i'
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            // 'i' can follow 'e' or 'o'
            dp[i][2] = (dp[i-1][0]+dp[i-1][4]+dp[i - 1][1] + dp[i - 1][3]) % MOD;
            // 'o' can follow 'i'
            dp[i][3] = (dp[i - 1][2]+dp[i-1][4])%MOD;
            // 'u' can follow 'i' or 'o'
            dp[i][4] = (dp[i - 1][0]) % MOD;
        }

        long result = 0;
        for (int i = 0; i < 5; i++) {
            result = (result + dp[n][i]) % MOD;
        }

        return (int) result;
    }
}
