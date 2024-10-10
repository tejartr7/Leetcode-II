class Solution {
    boolean[] infected;
    boolean[] visited;
    Map<Integer, List<Integer>> graph;
    
    public void dfs(int node) {
        if (visited[node]) return;
        visited[node] = true;
        infected[node] = true;
        
        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    dfs(neighbor);
                }
            }
        }
    }
    
    public List<Integer> remainingMethods(int n, int k, int[][] arr) {
        List<Integer> remainingNodes = new ArrayList<>();
        Set<Integer> resultSet = new HashSet<>();
        infected = new boolean[n];
        visited = new boolean[n];
        graph = new HashMap<>();
        
        // Build the graph with unidirectional edges
        for (int[] edge : arr) {
            int x = edge[0], y = edge[1];
            graph.computeIfAbsent(x, v -> new ArrayList<>()).add(y);
        }
        
        // Initial DFS from node `k` with unidirectional edges
        dfs(k);
        
        // Make the graph bidirectional
        for (int[] edge : arr) {
            int x = edge[0], y = edge[1];
            graph.computeIfAbsent(y, v -> new ArrayList<>()).add(x);
        }
        
        // Check each component
        boolean[] componentVisited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!infected[i] && !componentVisited[i]) {
                boolean[] tempVisited = new boolean[n];
                findComponent(i, resultSet, componentVisited);
            }
        }
        
        remainingNodes.addAll(resultSet);
        return remainingNodes;
    }
    
    private void findComponent(int node, Set<Integer> resultSet, boolean[] tempVisited) {
        if (tempVisited[node]) return;
        
        tempVisited[node] = true;
        resultSet.add(node);
        
        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (!tempVisited[neighbor]) {
                    findComponent(neighbor, resultSet, tempVisited);
                }
            }
        }
    }
}
