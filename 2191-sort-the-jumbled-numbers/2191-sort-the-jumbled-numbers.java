import java.util.PriorityQueue;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int valCompare = Integer.compare(a[1], b[1]);
            return valCompare != 0 ? valCompare : Integer.compare(a[0], b[0]);
        });

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (char ch : String.valueOf(nums[i]).toCharArray()) {
                sb.append(mapping[ch - '0']);
            }
            int transformedValue = Integer.parseInt(sb.toString());
            pq.offer(new int[] { i, transformedValue });
        }

        int[] ans = new int[n];
        int index = 0;
        while (!pq.isEmpty()) {
            int[] entry = pq.poll();
            ans[index++] = nums[entry[0]];
        }

        return ans;
    }
}
