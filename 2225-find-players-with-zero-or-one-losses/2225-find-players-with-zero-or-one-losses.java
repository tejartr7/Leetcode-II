class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int[] x : matches) {
            int a = x[0];
            int b = x[1];
            map1.put(a, map1.getOrDefault(a, 0) + 1);
            map2.put(b, map2.getOrDefault(b, 0) + 1);
        }

        for (int x : map1.keySet()) {
            if (!map2.containsKey(x)) {
                ans1.add(x);
            }
        }

        for (int x : map2.keySet()) {
            if (map2.get(x) == 1) {
                ans2.add(x);
            }
        }

        // Sort ans1 and ans2
        Collections.sort(ans1);
        Collections.sort(ans2);

        list.add(ans1);
        list.add(ans2);
        return list;
    }
}