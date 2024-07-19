import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] rowMin = new int[m];
        int[] colMax = new int[n];
        
        // Initialize the rowMin and colMax arrays
        for (int i = 0; i < m; i++) {
            rowMin[i] = Integer.MAX_VALUE;
        }
        
        for (int j = 0; j < n; j++) {
            colMax[j] = Integer.MIN_VALUE;
        }
        
        // Find the minimum values in each row
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < rowMin[i]) {
                    rowMin[i] = matrix[i][j];
                }
            }
        }
        
        // Find the maximum values in each column
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] > colMax[j]) {
                    colMax[j] = matrix[i][j];
                }
            }
        }
        
        // Find the lucky numbers
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == rowMin[i] && matrix[i][j] == colMax[j]) {
                    list.add(matrix[i][j]);
                }
            }
        }
        
        return list;
    }
}
