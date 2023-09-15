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
            String currentKey = currentPair.x + ":" + currentPair.y; // Create a unique key
            
            set.add(currentKey);
            
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    pair neighborPair = new pair(p[j][0], p[j][1]);
                    String neighborKey = neighborPair.x + ":" + neighborPair.y; // Create a unique key
                    int dist = Math.abs(p[i][0] - p[j][0]) + Math.abs(p[i][1] - p[j][1]);
                    
                    map.putIfAbsent(currentKey, new ArrayList<>()); // Ensure the list exists
                    map.get(currentKey).add(new tuple(neighborPair.x, neighborPair.y, dist));
                }
            }
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
            for (tuple k : map.getOrDefault(tempKey, new ArrayList<>())) { // Use getOrDefault to handle null
                String adjacentKey = k.x + ":" + k.y; // Create a unique key
             //   System.out.println(set);
                if (set.contains(adjacentKey)) {
                    pq.offer(k);
                }
            }
        }
        return ans;
    }
}
