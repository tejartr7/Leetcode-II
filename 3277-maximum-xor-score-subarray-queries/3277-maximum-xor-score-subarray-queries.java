class Solution {
    public int[] maximumSubarrayXor(int[] nums, int[][] queries) {
        int n = nums.length;

        int[][] t = new int[n][n];
        for (int j = 0; j < n; j++) {
            t[j][j] = nums[j];
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i + j < n; i++) {
                t[i][i + j] = t[i][i + j - 1] ^ t[i + 1][i + j];
            }
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i + j < n; i++) {
                t[i][i + j] = Math.max(t[i][i + j],
                        Math.max(t[i][i + j - 1], t[i + 1][i + j]));
            }
        }

        int[] res = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            res[idx++] = t[query[0]][query[1]];
        }
        return res;
    }
}