class Solution {
    Set<String> set = new HashSet<>();
    int dp[];

    public int helper(int idx, String s) {
        if (idx >= s.length()) return 0;
        if (dp[idx] != -1) return dp[idx];

        int ans = 1 + helper(idx + 1, s); 
        
        for (int x = idx; x < s.length(); x++) {
            String subStr = s.substring(idx, x + 1);
            if (set.contains(subStr)) {
                ans = Math.min(ans, helper(x + 1, s));
            }
        }

        dp[idx] = ans;
        return dp[idx];
    }

    public int minExtraChar(String s, String[] arr) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        for (String x : arr) {
            set.add(x);
        }
        return helper(0, s);
    }
}
