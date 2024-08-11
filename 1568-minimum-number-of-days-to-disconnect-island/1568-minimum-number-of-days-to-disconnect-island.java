class Solution {
    public int minDays(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // If the grid is already disconnected, return 0
        if (helper(grid) != 1) {
            return 0;
        }

        // Try turning each land cell into water and check if it disconnects the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (helper(grid) != 1) {
                        return 1;
                    }
                    grid[i][j] = 1; // Revert the change
                }
            }
        }

        // If turning one land cell into water doesn't work, it takes 2 days
        return 2;
    }

    // Helper method to count the number of islands in the grid
    private int helper(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int islandCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }

    // Depth-First Search (DFS) to explore an island
    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        // Explore the 4 possible directions (up, down, left, right)
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i, j - 1);
        dfs(grid, visited, i, j + 1);
    }
}
