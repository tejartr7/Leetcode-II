class Solution {
    public int countPairs(List<List<Integer>> list, int k) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        int i, j;
        int n = list.size();
        int ans = 0;
        for (i = 0; i < n; i++) {
            int x = list.get(i).get(0);
            int y = list.get(i).get(1);
            for (j = 0; j <= k; j++) {
                int x1 = x ^ j;
                int y1 = y ^ (k - j);
                if (map.containsKey(x1) && map.get(x1).containsKey(y1))
                    ans += map.get(x1).get(y1);
            }
            if (!map.containsKey(x))
                map.put(x, new HashMap<>());
            map.get(x).put(y, map.get(x).getOrDefault(y, 0) + 1);
        }
        return ans;
    }
}
