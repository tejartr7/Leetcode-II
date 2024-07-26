import java.util.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Create adjacency list
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            graph[u].add(new int[]{v, weight});
            graph[v].add(new int[]{u, weight});
        }

        int minReachableCities = Integer.MAX_VALUE;
        int cityWithMinReachableCities = -1;

        for (int i = 0; i < n; i++) {
            int reachableCities = dijkstra(i, n, graph, distanceThreshold);
            if (reachableCities < minReachableCities) {
                minReachableCities = reachableCities;
                cityWithMinReachableCities = i;
            } else if (reachableCities == minReachableCities) {
                cityWithMinReachableCities = Math.max(cityWithMinReachableCities, i);
            }
        }

        return cityWithMinReachableCities;
    }

    private int dijkstra(int src, int n, List<int[]>[] graph, int distanceThreshold) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int d = current[1];

            if (d > dist[u]) {
                continue;
            }

            for (int[] neighbor : graph[u]) {
                int v = neighbor[0];
                int weight = neighbor[1];
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        int reachableCities = 0;
        for (int d : dist) {
            if (d <= distanceThreshold) {
                reachableCities++;
            }
        }

        return reachableCities - 1; // excluding the city itself
    }
}
