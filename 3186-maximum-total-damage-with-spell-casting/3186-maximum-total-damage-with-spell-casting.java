class Solution {
    Map<Integer, Long> map;
    TreeMap<Integer, Long> treemap;

    public long helper(Integer pow){
        if(pow == null || !treemap.containsKey(pow)) return 0;
        if(map.containsKey(pow)) return map.get(pow);

        long not = helper(treemap.ceilingKey(pow + 1));
        long take = (long)(pow)*treemap.get(pow) + helper(treemap.ceilingKey(pow + 3));

        map.put(pow, Math.max(take, not));
        return Math.max(take, not);
    }

    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        treemap = new TreeMap<>();
        map = new HashMap<>();

        for(int x : power){
            treemap.put(x, treemap.getOrDefault(x, 0L) + (long)(1));
        }

        return helper(treemap.firstKey());
    }
}
