class Solution {
    int dp[][];

    public int helper(int l, int r, List<Integer> list, int v) {
        if (r-l+1<=1)
            return 0;

        if (dp[l][r] != -1)
            return dp[l][r];

        int ans = Integer.MAX_VALUE;

        
        ans = Math.min(ans, Math.min(v, list.get(r) - list.get(l)) + helper(l + 1, r - 1, list, v));
        ans = Math.min(ans, Math.min(v, list.get(r) - list.get(r - 1)) + helper(l, r -2, list, v));
        ans = Math.min(ans, Math.min(v, list.get(l + 1) - list.get(l)) + helper(l + 2, r, list, v));
        dp[l][r] = ans;
        return ans;
    }

    public int minOperations(String s1, String s2, int x) {
        int i, j, n = s1.length();
        List<Integer> list = new ArrayList<>();
        dp = new int[501][501];
        for (int xx[] : dp)
            Arrays.fill(xx, -1);
        for (i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                list.add(i);
            }
        }
        if (list.size() % 2 == 1) {
           return -1;
        }
        return helper(0, list.size() - 1, list, x);
    }
}
