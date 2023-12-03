class Solution {
    private List<int[]> ranges;

    private int func(int x, int k, String s) {
        int ans = 0;
        for (int[] it : ranges) {
            int i = it[0], j = it[0], e = it[1];
            int cntk = 0;
            Map<Character, Integer> mp = new HashMap<>();
            for (j = it[0]; j <= e; j++) {
                mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
                if (mp.get(s.charAt(j)) == k) cntk++;
                if (j - i + 1 > (x * k)) {
                    mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                    if (mp.get(s.charAt(i)) == (k - 1)) cntk--;
                    if (mp.get(s.charAt(i)) == 0) mp.remove(s.charAt(i));
                    i++;
                }
                if (mp.size() == x && cntk == mp.size()) ans++;
            }
        }
        return ans;
    }

    public int countCompleteSubstrings(String word, int k) {
        ranges = new ArrayList<>();
        List<Integer> v = new ArrayList<>();
        for (int i = 1; i < word.length(); i++) {
            if (i < word.length() && Math.abs(word.charAt(i) - word.charAt(i - 1)) > 2) {
                v.add(i);
            }
        }

        int st = 0, e = word.length() - 1;
        for (int it : v) {
            if (st <= it - 1)
                ranges.add(new int[]{st, it - 1});
            st = it;
        }
        if (st <= e)
            ranges.add(new int[]{st, e});

        int ans = 0;
        for (int i = 1; i <= 26 && i * k <= word.length(); i++) {
            ans += func(i, k, word);
        }
        return ans;
    }
}