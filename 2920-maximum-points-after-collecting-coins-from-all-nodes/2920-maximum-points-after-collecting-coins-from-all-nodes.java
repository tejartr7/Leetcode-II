public class Solution {
    int[] coins;
    Map<Integer, List<Integer>> map;
    int k;
    int[][] dp;

    public int helper(int node, int par, int div) {
        if (div > 14) return Integer.MIN_VALUE;

        int temp = div;
        int val = coins[node];
        
        if (dp[node][div] != -1) return dp[node][div];

        while (temp-- > 0)
            val /= 2;

        int a = val / 2;
        for (int x : map.get(node)) {
            if (par != x) {
                a += helper(x, node, div + 1);
            }
        }

        int b = val - k;
        for (int x : map.get(node)) {
            if (par != x) {
                b += helper(x, node, div);
            }
        }

        dp[node][div] = Math.max(a, b);
        return dp[node][div];
    }

    public int maximumPoints(int[][] edges, int[] coins, int k) {
        int n = edges.length + 1;
        map = new HashMap<>();
        dp = new int[n][15];
        
        for (int[] x : dp)
            Arrays.fill(x, -1);

        this.coins = coins;
        this.k = k;

        for (int i = 0; i < n; i++)
            map.put(i, new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            int x = edges[i][0], y = edges[i][1];
            map.get(x).add(y);
            map.get(y).add(x);
        }

        return helper(0, -1, 0);
    }
}
