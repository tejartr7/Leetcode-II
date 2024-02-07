class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i, n = s.length();
        for (i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> (map.get(b) - map.get(a)));
        pq.addAll(map.keySet());
        String ans = "";
        while (!pq.isEmpty()) {
            char ch = pq.poll();
            int count = map.get(ch);
            String temp = String.valueOf(ch);
            ans += temp.repeat(count);
            map.remove(ch);
        }
        return ans;
    }
}