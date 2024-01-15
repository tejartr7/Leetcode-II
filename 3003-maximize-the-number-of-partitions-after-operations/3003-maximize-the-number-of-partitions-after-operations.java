class Solution {
    Map<Long,Integer> map=new HashMap<>();
    public int solve(String s, int idx, int k, long val, boolean change) {
        int n = s.length();
        if (idx >= n)
            return 0;
        long key = ((long) idx << 27)
                | ((long) val << 1)
                | (change ? 1 : 0);
        if(map.containsKey(key))
            return map.get(key);
        int res = 0;
        int ch = s.charAt(idx) - 'a';
        long updated = val | (1L << ch);
        int cnt = Long.bitCount(updated);

        if (cnt > k) {
            res = 1 + solve(s, idx + 1, k, (1L << ch), change);
        } else {
            res = solve(s, idx + 1, k, updated, change);
        }

        if (change) {
            for (int i = 0; i < 26; i++) {
                    long newVal = val | (1L << i);
                    cnt = Long.bitCount(newVal);

                    if (cnt > k) {
                        res = Math.max(res, 1 + solve(s, idx + 1, k, (1L << i), false));
                    } else {
                        res = Math.max(res, solve(s, idx + 1, k, newVal, false));
                    }
                }
        }
        map.put(key,res);
        return res;
    }

    public int maxPartitionsAfterOperations(String s, int k) {
        int n = s.length();
        return 1+solve(s, 0, k, 0, true);
    }
}
