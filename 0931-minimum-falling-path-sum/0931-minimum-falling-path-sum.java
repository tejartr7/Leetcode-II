class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int minPrev = matrix[i - 1][j];

                if (j > 0) {
                    minPrev = Math.min(minPrev, matrix[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    minPrev = Math.min(minPrev, matrix[i - 1][j + 1]);
                }

                matrix[i][j] += minPrev;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int x : matrix[m - 1]) {
            ans = Math.min(ans, x);
        }

        return ans;
    }
}
