import java.util.*;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        // Step 1: Build the adjacency list for both graphs
        Map<Integer, List<Integer>> graph1 = new HashMap<>();
        Map<Integer, List<Integer>> graph2 = new HashMap<>();
        int m = edges1.length, n = edges2.length;
        
        // Build the graph for edges1
        for (int i = 0; i < m; i++) {
            int u = edges1[i][0];
            int v = edges1[i][1];
            graph1.putIfAbsent(u, new ArrayList<>());
            graph1.putIfAbsent(v, new ArrayList<>());
            graph1.get(u).add(v);
            graph1.get(v).add(u);
        }
        
        // Build the graph for edges2
        for (int i = 0; i < n; i++) {
            int u = edges2[i][0];
            int v = edges2[i][1];
            graph2.putIfAbsent(u, new ArrayList<>());
            graph2.putIfAbsent(v, new ArrayList<>());
            graph2.get(u).add(v);
            graph2.get(v).add(u);
        }
        
        // Step 2: Perform DFS to count all nodes within distance <= k for both graphs
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        // Perform DFS for graph1 and graph2 starting from node 0
        Set<Integer> visited1 = new HashSet<>(); // Visited set for graph1
        Set<Integer> visited2 = new HashSet<>(); // Visited set for graph2
        
        // DFS for graph1
        for (int node = 0; node < graph1.size(); node++) {
            visited1 = new HashSet<>();
            dfs(node, -1, 0, k, graph1, map1, visited1);
        }
        //System.out.println(map1);
        // DFS for graph2
        for (int node = 0; node < graph2.size(); node++) {
            visited2 = new HashSet<>();
            dfs(node, -1, 0, k - 1, graph2, map2, visited2);
        }
        //System.out.println(map1);
        // Step 3: Calculate the result by combining the results from both graphs
        int[] ans = new int[graph1.size()];
        for (int i = 0; i < graph1.size(); i++) {
            int max = 0;
            for (int x : map2.keySet()) {
                max = Math.max(max, map2.get(x));
            }
            ans[i] = max + map1.getOrDefault(i, 0);
        }
        return ans;
    }
    
    // DFS helper method to count reachable nodes within distance <= k
    private void dfs(int node, int parent, int cnt, int k, Map<Integer, List<Integer>> graph, 
                     Map<Integer, Integer> map, Set<Integer> visited) {
        // Base case: if the current distance exceeds k, return
        if (cnt > k) return;
        
        // Mark the node as visited
        visited.add(node);
        
        // If this node has not been processed yet, initialize its count.
        if (!map.containsKey(node)) {
            map.put(node, 0);
        }
        
        // Increment the count for this node
        map.put(node, map.get(node) + 1);
        
        // Explore the neighbors
        for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (!visited.contains(neighbor)) { // Avoid revisiting nodes
                dfs(neighbor, node, cnt + 1, k, graph, map, visited);
            }
        }
    }
}
