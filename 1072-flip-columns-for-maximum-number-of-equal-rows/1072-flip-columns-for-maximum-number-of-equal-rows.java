class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < m; i++) {
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < n; j++) {
                // Represent the row as if the first column is always '0'
                key.append(matrix[i][j] == matrix[i][0] ? '1' : '0');
            }
            String rowKey = key.toString();
            map.put(rowKey, map.getOrDefault(rowKey, 0) + 1);
            ans = Math.max(ans, map.get(rowKey));
        }

        return ans;
    }
}
