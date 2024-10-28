class Solution {
    public int longestSquareStreak(int[] nums) {
        boolean[] vis = new boolean[100001];
        int n = nums.length;
        for (int num : nums) {
            if (num <= 100000) {
                vis[num] = true;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (x == 1) break;
            if (x >= 1000) continue;
            int cnt = 0;
            while (x <= 100000 && vis[x]) {
                cnt++;
                long temp = (long) x * x;
                if (temp > 100000) break;
                x = (int) temp;
            }
            max = Math.max(max, cnt);
        }
        return max >= 2 ? max : -1;
    }
}
