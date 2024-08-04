import java.util.*;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        long mod = 1000_000_007;
        long ans = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate through each subarray and use a min-heap to maintain the smallest sums
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                minHeap.offer(sum);
            }
        }

        // Extract the required sums from the min-heap
        for (int i = 1; i <= right; i++) {
            int min = minHeap.poll();
            if (i >= left) {
                ans = (ans + min) % mod;
            }
        }

        return (int) (ans % mod);
    }
}
