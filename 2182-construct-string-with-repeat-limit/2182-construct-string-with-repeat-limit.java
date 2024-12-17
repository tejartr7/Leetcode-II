class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // PriorityQueue to hold characters sorted by their frequency and character value
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                pq.offer(new int[]{i, cnt[i]}); // [character index, count]
            }
        }

        StringBuilder ans = new StringBuilder();

        while (!pq.isEmpty()) {
            int[] top = pq.poll(); // Current most frequent character
            int ch = top[0];
            int count = top[1];

            // Add the character up to `repeatLimit` times
            int times = Math.min(count, repeatLimit);
            for (int i = 0; i < times; i++) {
                ans.append((char) (ch + 'a'));
            }

            count -= times;

            if (count > 0) {
                // If there are still occurrences left, we need to insert an alternate character
                if (pq.isEmpty()) {
                    // If no alternate character is available, break
                    break;
                }

                int[] next = pq.poll(); // Second most frequent character
                int nextCh = next[0];
                int nextCount = next[1];

                // Insert one occurrence of the alternate character
                ans.append((char) (nextCh + 'a'));
                nextCount--;

                // Push the remaining occurrences back into the queue
                if (nextCount > 0) {
                    pq.offer(new int[]{nextCh, nextCount});
                }
                pq.offer(new int[]{ch, count}); // Reinsert the current character with remaining count
            }
        }

        return ans.toString();
    }
}