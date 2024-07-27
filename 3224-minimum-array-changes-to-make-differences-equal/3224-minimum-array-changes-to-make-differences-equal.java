import java.util.*;

public class Solution {
    public int minChanges(int[] nums, int k) {
        List<Integer> maxDeltas = new ArrayList<>();
        List<Integer> deltas = new ArrayList<>();

        for (int i = 0; i < nums.length / 2; i++) {
            int maxDelta = Math.max(nums[i], Math.max(nums[nums.length - i - 1], k - Math.min(nums[i], nums[nums.length - i - 1])));
            maxDeltas.add(maxDelta);
            deltas.add(Math.abs(nums[i] - nums[nums.length - i - 1]));
        }

        Collections.sort(maxDeltas);
        Map<Integer, Integer> counter = new HashMap<>();
        for (int delta : deltas) {
            counter.put(delta, counter.getOrDefault(delta, 0) + 1);
        }

        int changes = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int targetDelta = entry.getKey();
            int count = entry.getValue();

            int onesStart = Collections.binarySearch(maxDeltas, targetDelta);
            if (onesStart < 0) {
                onesStart = -onesStart - 1;
            } else {
                while (onesStart > 0 && maxDeltas.get(onesStart - 1).equals(targetDelta)) {
                    onesStart--;
                }
            }

            int curChanges = -count + onesStart * 2 + (maxDeltas.size() - onesStart);
            changes = Math.min(changes, curChanges);
        }

        return changes;
    }
}
