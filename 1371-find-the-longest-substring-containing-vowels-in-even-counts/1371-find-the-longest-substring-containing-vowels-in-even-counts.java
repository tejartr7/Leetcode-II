class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        int temp = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == 'a') {
                temp ^= (1 << 0);
            } else if (ch == 'e') {
                temp ^= (1 << 1);
            } else if (ch == 'i') {
                temp ^= (1 << 2);
            } else if (ch == 'o') {
                temp ^= (1 << 3);
            } else if (ch == 'u') {
                temp ^= (1 << 4);
            }

            if (map.containsKey(temp)) {
                ans = Math.max(ans, i - map.get(temp));
            } else {
                map.put(temp, i);
            }
        }

        return ans;
    }
}
