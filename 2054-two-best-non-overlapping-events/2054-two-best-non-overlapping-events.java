class Solution {
    int dp[][];
    public int helper(int idx, int choices, int[][] events) {
        if (idx >= events.length) return 0;
        if (choices >= 2) return 0;
        if (dp[idx][choices] != -1) return dp[idx][choices];
        
        int ans = helper(idx + 1, choices, events);
        int nextIdx = binarySearch(events, events[idx][1]);
        ans = Math.max(ans, events[idx][2] + helper(nextIdx, choices + 1, events));
        
        return dp[idx][choices] = ans;
    }

    private int binarySearch(int[][] events, int endTime) {
        int left = 0, right = events.length - 1, result = events.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (events[mid][0] > endTime) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        dp = new int[n+1][3];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return helper(0, 0, events);
    }
}
