import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        int i, j = 0, m = s.length(), n = t.length();
        int need = 0;
        int len = 10000000;
        String ans = "";

        for (i = 0; i < n; i++) {
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (i = 0; i < m; i++) {
            map2.put(s.charAt(i), map2.getOrDefault(s.charAt(i), 0) + 1);

            if (map1.containsKey(s.charAt(i)) && map2.get(s.charAt(i)) <= map1.get(s.charAt(i))) {
                need++;
            }

            while (j < m && need == n) {
                if (i - j + 1 < len) {
                    len = i - j + 1;
                    ans = s.substring(j, i + 1);
                }

                map2.put(s.charAt(j), map2.get(s.charAt(j)) - 1);

                if (map1.containsKey(s.charAt(j)) && map2.get(s.charAt(j)) < map1.get(s.charAt(j))) {
                    need--;
                }

                j++;
            }
        }

        return ans;
    }
}
