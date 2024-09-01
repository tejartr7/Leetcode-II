import java.util.*;

class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        // Min-heap to keep track of the k closest obstacles
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Collections.reverseOrder());
        int n = queries.length;
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int dist = Math.abs(x) + Math.abs(y);
            
            // Add the current distance to the heap
            minHeap.offer(dist);
            
            // If the heap size exceeds k, remove the largest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            
            // If the heap has k elements, the k-th smallest distance is at the top
            if (minHeap.size() == k) {
                ans[i] = minHeap.peek();
            } else {
                ans[i] = -1;  // Less than k elements
            }
        }
        
        return ans;
    }
}
