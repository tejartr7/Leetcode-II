class Solution {
    long mod = 1000000007;
    long dp[][][];

    public boolean valid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public long helper(int x, int y, int cnt, int m, int n) {
        if (!valid(x, y, m, n))
            return 1L;
        if (cnt == 0)
            return 0;
        if (dp[x][y][cnt] != -1)
            return dp[x][y][cnt];
        long ans = 0;
        ans += helper(x + 1, y, cnt - 1, m, n);
        ans += helper(x - 1, y, cnt - 1, m, n);
        ans += helper(x, y + 1, cnt - 1, m, n);
        ans += helper(x, y - 1, cnt - 1, m, n);
        return dp[x][y][cnt] = ans % mod;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new long[m][n][maxMove + 1];
        for (long x[][] : dp) {
            for (long y[] : x) {
                Arrays.fill(y, -1);
            }
        }
        return (int)(helper(startRow, startColumn, maxMove, m, n)%mod);
    }
}
