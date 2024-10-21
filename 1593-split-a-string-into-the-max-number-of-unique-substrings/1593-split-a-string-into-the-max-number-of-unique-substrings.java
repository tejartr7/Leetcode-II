class Solution {
    int n;
    int maxi = 0;
    Set<String> set;
    
    public void helper(int idx, String s) {
        if (idx >= n) {
            maxi = Math.max(maxi, set.size());
            return;
        }
        for (int i = idx + 1; i <= n; i++) {
            String temp = s.substring(idx, i);
            if (!set.contains(temp)) {
                set.add(temp);
                helper(i, s);
                set.remove(temp);
            }
        }
    }
    
    public int maxUniqueSplit(String s) {
        n = s.length();
        set = new HashSet<>();
        helper(0, s);
        return maxi;
    }
}
