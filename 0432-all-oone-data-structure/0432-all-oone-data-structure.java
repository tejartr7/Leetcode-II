import java.util.*;

class AllOne {
    private Map<String, Integer> stringCountMap;
    private TreeMap<Integer, Set<String>> sortedCountMap;

    public AllOne() {
        stringCountMap = new HashMap<>();
        sortedCountMap = new TreeMap<>(Collections.reverseOrder());
    }

    public void inc(String key) {
        int oldCount = stringCountMap.getOrDefault(key, 0);
        if (oldCount > 0) {
            sortedCountMap.get(oldCount).remove(key);
            if (sortedCountMap.get(oldCount).isEmpty()) {
                sortedCountMap.remove(oldCount);
            }
        }

        int newCount = oldCount + 1;
        stringCountMap.put(key, newCount);
        sortedCountMap.computeIfAbsent(newCount, k -> new HashSet<>()).add(key);
    }

    public void dec(String key) {
        int oldCount = stringCountMap.getOrDefault(key, 0);

        if (oldCount == 0) {
            return;
        }

        sortedCountMap.get(oldCount).remove(key);
        if (sortedCountMap.get(oldCount).isEmpty()) {
            sortedCountMap.remove(oldCount);
        }

        int newCount = oldCount - 1;

        if (newCount == 0) {
            stringCountMap.remove(key);
        } else {
            stringCountMap.put(key, newCount);
            sortedCountMap.computeIfAbsent(newCount, k -> new HashSet<>()).add(key);
        }
    }

    public List<Map.Entry<String, Integer>> getSortedByCount() {
        List<Map.Entry<String, Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : sortedCountMap.entrySet()) {
            for (String s : entry.getValue()) {
                result.add(new java.util.AbstractMap.SimpleEntry<>(s, entry.getKey()));
            }
        }
        return result;
    }

    public String getMaxKey() {
        if (sortedCountMap.isEmpty()) {
            return "";
        }
        return sortedCountMap.firstEntry().getValue().iterator().next();
    }

    public String getMinKey() {
        if (sortedCountMap.isEmpty()) {
            return "";
        }
        return sortedCountMap.lastEntry().getValue().iterator().next();
    }
}
