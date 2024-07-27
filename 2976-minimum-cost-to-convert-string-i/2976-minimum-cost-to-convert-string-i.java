class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int i, j, l = cost.length, n = source.length();
        long ans = 0;
        Map<Character, List<Pair>> map = new HashMap<>();
        
        // Populate the map with transformations
        for (i = 0; i < l; i++) {
            char a = original[i];
            char b = changed[i];
            int c = cost[i];
            if (!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            map.get(a).add(new Pair(b, c));
        }
        int[][] arr = new int[26][26];
        for (i = 0; i < 26; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
            arr[i][i] = 0;
        }
        for (Map.Entry<Character, List<Pair>> entry : map.entrySet()) {
            char from = entry.getKey();
            for (Pair pair : entry.getValue()) {
                char to = pair.character;
                int c = pair.cost;
                arr[from - 'a'][to - 'a'] = Math.min(arr[from - 'a'][to - 'a'], c);
            }
        }
        for (int k = 0; k < 26; k++) {
            for (i = 0; i < 26; i++) {
                for (j = 0; j < 26; j++) {
                    if (arr[i][k] != Integer.MAX_VALUE && arr[k][j] != Integer.MAX_VALUE) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }
        for (i = 0; i < n; i++) {
            if (source.charAt(i) != target.charAt(i)) {
                int from = source.charAt(i) - 'a';
                int to = target.charAt(i) - 'a';
                if (arr[from][to] == Integer.MAX_VALUE) {
                    return -1; 
                }
                ans += arr[from][to];
            }
        }
        
        return ans;
    }
    class Pair {
        char character;
        int cost;
        
        Pair(char character, int cost) {
            this.character = character;
            this.cost = cost;
        }
    }
}
