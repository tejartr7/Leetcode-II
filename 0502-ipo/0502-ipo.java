class pair {
    int x, y;
    pair(int a, int b) {
        x = a;
        y = b;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int i, n = profits.length;
        int ans = w;

        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.x != b.x ? a.x - b.x : b.y - a.y);

        for (i = 0; i < n; i++) {
            pq.offer(new pair(capital[i], profits[i]));
        }

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (i = 0; i < k; i++) {
            while (!pq.isEmpty() && pq.peek().x <= ans) {
                q.offer(pq.poll().y);
            }

            if (q.isEmpty()) {
                break;
            }

            ans += q.poll();
        }

        return ans;
    }
}
