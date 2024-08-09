class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int cnt = 0;
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (isValid(i, j, grid)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private boolean isValid(int i, int j, int[][] grid) {
        boolean[] seen = new boolean[10];
        for (int a = i; a < i + 3; a++) {
            for (int b = j; b < j + 3; b++) {
                int val = grid[a][b];
                if (val < 1 || val > 9 || seen[val]) return false;
                seen[val] = true;
            }
        }

        int sum1 = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];
        int sum2 = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
        int sum3 = grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2];
        int sum4 = grid[i][j] + grid[i + 1][j] + grid[i + 2][j];
        int sum5 = grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
        int sum6 = grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2];
        int sum7 = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        int sum8 = grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j];

        return sum1 == sum2 && sum2 == sum3 && sum3 == sum4 &&
               sum4 == sum5 && sum5 == sum6 && sum6 == sum7 && sum7 == sum8;
    }
}