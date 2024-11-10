class Solution {
    public int maxFrequency(int[] A, int k, int numOperations) {
        Arrays.sort(A);

        // Case 1
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0, i = 0, j = 0, n = A.length;
        for (int a : A) {
            while (j < n && A[j] <= a + k) {
                count.put(A[j], count.getOrDefault(A[j], 0) + 1);
                j++;
            }
            while (i < n && A[i] < a - k) {
                count.put(A[i], count.get(A[i]) - 1);
                i++;
            }
            int cur = Math.min(j - i, count.getOrDefault(a, 0) + numOperations);
            res = Math.max(res, cur);
        }

        // Case 2
        for (i = 0, j = 0; j < n; j++) {
            int mid=(A[i]+A[j])/2;
            while(mid - A[i] > k || A[j] - mid > k) {
                i++;
                mid = (A[i] + A[j]) / 2;
            }
            res = Math.max(res, Math.min(j - i + 1, numOperations));
        }
        return res;
    }
}
