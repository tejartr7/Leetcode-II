import java.util.Arrays;

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        
        // Mark walls and guards on the grid
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 3; // 3 = Wall
        }
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2; // 2 = Guard
        }

        // Sweep left-to-right and right-to-left for rows
        for (int i = 0; i < m; i++) {
            boolean guarded = false;
            for (int j = 0; j < n; j++) { // Left-to-right
                if (grid[i][j] == 2) {
                    guarded = true; // Start guarding
                } else if (grid[i][j] == 3) {
                    guarded = false; // Wall breaks the guard
                } else if (guarded) {
                    grid[i][j] = 1; // Mark as guarded
                }
            }
            guarded = false;
            for (int j = n - 1; j >= 0; j--) { // Right-to-left
                if (grid[i][j] == 2) {
                    guarded = true;
                } else if (grid[i][j] == 3) {
                    guarded = false;
                } else if (guarded) {
                    grid[i][j] = 1;
                }
            }
        }

        // Sweep top-to-bottom and bottom-to-top for columns
        for (int j = 0; j < n; j++) {
            boolean guarded = false;
            for (int i = 0; i < m; i++) { // Top-to-bottom
                if (grid[i][j] == 2) {
                    guarded = true;
                } else if (grid[i][j] == 3) {
                    guarded = false;
                } else if (guarded) {
                    grid[i][j] = 1;
                }
            }
            guarded = false;
            for (int i = m - 1; i >= 0; i--) { // Bottom-to-top
                if (grid[i][j] == 2) {
                    guarded = true;
                } else if (grid[i][j] == 3) {
                    guarded = false;
                } else if (guarded) {
                    grid[i][j] = 1;
                }
            }
        }

        // Count unguarded cells
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) { // 0 = Unguarded
                    count++;
                }
            }
        }

        return count;
    }
}
