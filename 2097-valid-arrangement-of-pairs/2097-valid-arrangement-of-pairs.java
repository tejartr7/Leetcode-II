class Solution {
    public void dfs(int node, Map<Integer, List<Integer>> adj, List<Integer> eulerPath) {
        while (adj.containsKey(node) && !adj.get(node).isEmpty()) {
            int nextNode = adj.get(node).remove(adj.get(node).size() - 1); // Remove the edge after visiting
            dfs(nextNode, adj, eulerPath);
        }
        eulerPath.add(node); // Add the node to the path after all edges are visited
    }

    public int[][] validArrangement(int[][] pairs) {
        int n = pairs.length;
        int[][] ans = new int[n][2];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();

        // Step-1: Build adjacency list and track in-degree/out-degree
        for (int[] edge : pairs) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
            indegree.put(v, indegree.getOrDefault(v, 0) + 1);
        }

        // Step-2: Determine the start node
        int startNode = pairs[0][0]; // Default to the first node in the input
        for (int node : adj.keySet()) {
            if (outdegree.getOrDefault(node, 0) - indegree.getOrDefault(node, 0) == 1) {
                startNode = node; // A node with outdegree > indegree by 1 is the start
                break;
            }
        }

        // Step-3: Perform DFS to construct the Eulerian path
        List<Integer> eulerPath = new ArrayList<>();
        dfs(startNode, adj, eulerPath);

        // Step-4: Reverse the path to get the correct order
        Collections.reverse(eulerPath);

        // Step-5: Build the result from the Eulerian path
        for (int i = 0; i < eulerPath.size() - 1; i++) {
            ans[i][0] = eulerPath.get(i);
            ans[i][1] = eulerPath.get(i + 1);
        }

        return ans;
    }
}
