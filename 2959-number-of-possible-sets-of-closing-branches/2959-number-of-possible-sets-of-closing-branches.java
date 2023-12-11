class Solution {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int ans = 0;
        for (int i = 0; i < (1 << n); i++) {
            int[][] g = new int[n][n];
            for (int[] row : g) {
                Arrays.fill(row, (int) 1e9);
            }

            for (int[] it : roads) {
                int x = it[0], y = it[1], w = it[2];
                if (((i >> x) & 1) == 1 && ((i >> y) & 1) == 1) {
                    g[x][y] = Math.min(g[x][y], w);
                    g[y][x] = Math.min(g[y][x], w);
                }
            }

            for (int j = 0; j < n; j++) {
                g[j][j] = 0;
            }

            for (int p = 0; p < n; p++) {
                for (int q = 0; q < n; q++) {
                    for (int k = 0; k < n; k++) {
                        g[q][k] = Math.min(g[q][k], g[q][p] + g[p][k]);
                    }
                }
            }

            int ok = 1;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (((i >> j) & 1) == 1 && ((i >> k) & 1) == 1) {
                        ok &= (g[j][k] <= maxDistance) ? 1 : 0;
                    }
                }
            }

            ans += ok;
        }
        return ans;
    }
}
