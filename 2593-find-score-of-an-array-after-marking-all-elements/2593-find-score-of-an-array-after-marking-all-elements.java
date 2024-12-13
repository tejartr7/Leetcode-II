import java.util.*;

class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;
        long ans = 0;

        // Create an array of pairs (value, index) and sort it
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        // Use a boolean array for visited indices
        boolean[] visited = new boolean[n];

        // Traverse sorted pairs
        for (int[] pair : pairs) {
            int value = pair[0];
            int index = pair[1];

            // If the index is already visited, skip it
            if (visited[index]) continue;

            // Add value to the score and mark indices as visited
            ans += value;
            visited[index] = true;
            if (index > 0) visited[index - 1] = true;
            if (index < n - 1) visited[index + 1] = true;
        }

        return ans;
    }
}
