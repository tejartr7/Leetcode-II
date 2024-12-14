class Solution {
    public long continuousSubarrays(int[] nums) {
        long res = 0;
        int i = 0, n = nums.length;

        // Deques to maintain the indices of max and min values
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        for (int j = 0; j < n; j++) {
            // Update the maxDeque: remove elements smaller than the current number
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[j]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(j);

            // Update the minDeque: remove elements larger than the current number
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[j]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(j);

            // Shrink the window if the condition is violated
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > 2) {
                if (maxDeque.peekFirst() == i) maxDeque.pollFirst();
                if (minDeque.peekFirst() == i) minDeque.pollFirst();
                i++;
            }

            // Count the subarrays ending at index j
            res += j - i + 1;
        }

        return res;
    }
}
