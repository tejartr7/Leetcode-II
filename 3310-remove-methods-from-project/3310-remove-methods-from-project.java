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
            if (!componentVisited[i]) {
                List<Integer> component = new ArrayList<>();
                boolean[] tempVisited = new boolean[n];
                findComponent(i, component, tempVisited);
                
                // Check if the component has any uninfected node
                boolean hasUninfected = false;
                for (int node : component) {
                    if (!infected[node]) {
                        hasUninfected = true;
                        break;
                    }
                }
                
                // If there’s an uninfected node, mark the whole component as uninfected
                if (hasUninfected) {
                    for (int node : component) {
                        resultSet.add(node);
                    }
                }
                
                // Mark the entire component as visited
                for (int node : component) {
                    componentVisited[node] = true;
                }
            }
        }
        
        remainingNodes.addAll(resultSet);
        return remainingNodes;
    }
    
    private void findComponent(int node, List<Integer> component, boolean[] tempVisited) {
        if (tempVisited[node]) return;
        
        tempVisited[node] = true;
        component.add(node);
        
        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                if (!tempVisited[neighbor]) {
                    findComponent(neighbor, component, tempVisited);
                }
            }
        }
    }
}
