import java.util.*;

class Solution {
    // Directions for moving the '0': up, down, left, right
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final String TARGET = "123450"; // Solved board state

    public int slidingPuzzle(int[][] board) {
        // Convert the initial board into a string representation
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start.append(board[i][j]);
            }
        }

        // If the board is already solved
        if (start.toString().equals(TARGET)) {
            return 0;
        }

        // BFS setup
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start.toString());
        visited.add(start.toString());
        int steps = 0;

        // The index mapping for the 2x3 grid
        int[][] gridIndex = {{0, 1, 2}, {3, 4, 5}};

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int q = 0; q < size; q++) {
                String current = queue.poll();

                // Find the position of '0'
                int zeroIndex = current.indexOf('0');
                int zeroRow = zeroIndex / 3;
                int zeroCol = zeroIndex % 3;

                // Try moving the '0' in all 4 directions
                for (int[] dir : DIRS) {
                    int newRow = zeroRow + dir[0];
                    int newCol = zeroCol + dir[1];

                    // Check if the new position is valid
                    if (newRow >= 0 && newRow < 2 && newCol >= 0 && newCol < 3) {
                        int newZeroIndex = gridIndex[newRow][newCol];

                        // Swap '0' with the adjacent tile
                        char[] chars = current.toCharArray();
                        chars[zeroIndex] = chars[newZeroIndex];
                        chars[newZeroIndex] = '0';

                        String next = new String(chars);

                        // If the solved state is reached
                        if (next.equals(TARGET)) {
                            return steps;
                        }

                        // If the state is not visited, add it to the queue
                        if (visited.add(next)) {
                            queue.offer(next);
                        }
                    }
                }
            }
        }

        // If no solution is found
        return -1;
    }
}