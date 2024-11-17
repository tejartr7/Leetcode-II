class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int i = 0; i <= n; i++) {
            while (!dq.isEmpty() && prefixSum[i] - prefixSum[dq.peekFirst()] >= k) {
                ans = Math.min(ans, i - dq.pollFirst());
            }

            while (!dq.isEmpty() && prefixSum[i] <= prefixSum[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
