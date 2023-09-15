class pair {
    int x;
    int y;

    pair(int a, int b) {
        x = a;
        y = b;
    }
}

class tuple {
    int x;
    int y;
    int wt;

    tuple(int a, int b, int c) {
        x = a;
        y = b;
        wt = c;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] p) {
        Map<String, List<tuple>> map = new HashMap<>();
        int n = p.length;
        int ans = 0;
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            pair currentPair = new pair(p[i][0], p[i][1]);
            String currentKey = currentPair.x + ":" + currentPair.y;
            set.add(currentKey);
        }

        PriorityQueue<tuple> pq = new PriorityQueue<>((x, y) -> x.wt - y.wt);
        pq.offer(new tuple(p[0][0], p[0][1], 0));

        while (!pq.isEmpty()) {
            tuple top = pq.poll();
            String tempKey = top.x + ":" + top.y; // Create a unique key
            if(!set.contains(tempKey))
                continue;
            set.remove(tempKey);
            ans += top.wt;
            for(int i=0;i<n;i++)
            {
                String key = p[i][0] + ":" + p[i][1];
                int dist=Math.abs(p[i][0]-top.x)+Math.abs(p[i][1]-top.y);
                if(!tempKey.equals(key))
                {
                    if(set.contains(key))
                    {
                        pq.offer(new tuple(p[i][0],p[i][1],dist));
                    }
                }
            }
        }
        return ans;
    }
}
