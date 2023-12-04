public class Solution {
    // Function to find a solved Sudoku.
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.'; // Undo the choice if it leads to an invalid solution
                            }
                        }
                    }
                    return false; // If no valid choice is found
                }
            }
        }
        return true; // Board is filled
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        for (int x = 0; x < 9; x++) {
            if (board[row][x] == num || board[x][col] == num || board[3 * (row / 3) + x / 3][3 * (col / 3) + x % 3] == num) {
                return false;
            }
        }
        return true;
    }
}
