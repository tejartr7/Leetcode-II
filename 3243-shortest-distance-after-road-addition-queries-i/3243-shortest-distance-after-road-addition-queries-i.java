import java.util.*;

class Solution {
    Map<Integer, ArrayList<Integer>> map;

    public int helper(int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[n];
        Arrays.fill(dist, 1000_000_000);
        dist[0] = 0;
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int curr = current[1];

            if (curr > dist[node]) continue;

            if (map.containsKey(node)) {
                for (int neighbor : map.get(node)) {
                    
                    // System.out.println(neighbor+" "+node);
                    int temp = curr + 1;
                    if (temp < dist[neighbor]) {
                        dist[neighbor] = temp;
                        pq.offer(new int[]{neighbor, temp});
                    }
                }
            }
        }
        // System.out.println(map);
        // for(int x:dist){
        //     System.out.print(x+" ");
        // }
        // System.out.println();
        return dist[n - 1] == 1000_000_000 ? -1 : dist[n - 1];
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int i, q = queries.length;
        int[] ans = new int[q];
        map = new HashMap<>();
        for (i = 0; i < n-1; i++) {
            if (!map.containsKey(i)) {
                map.put(i, new ArrayList<>());
            }
            map.get(i).add(i + 1);
        }
        for (i = 0; i < q; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (!map.containsKey(a))
                map.put(a, new ArrayList<>());
            map.get(a).add(b);
            int temp = helper(n);
            ans[i] = temp;
        }
        return ans;
    }
}
