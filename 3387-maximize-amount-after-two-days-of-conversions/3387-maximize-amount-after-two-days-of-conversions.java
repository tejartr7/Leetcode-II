class Solution {
    String initialCurrency;
    List<List<Object>> currencies = new ArrayList<>(); // Use List<Object> to store both String and Double
    double maxi = 1.0; // Use double for maximum value

    public void dfs1(Map<String, Map<String, Double>> graph, String u, double w, Set<String> visited) {
        if (visited.contains(u)) return;
        visited.add(u);
        if(!graph.containsKey(u)) return ;

        for (String v : graph.get(u).keySet()) {
            if (!visited.contains(v)) {
                currencies.add(Arrays.asList(v, w * graph.get(u).get(v)));
                dfs1(graph, v, w * graph.get(u).get(v), visited);
            }
        }
    }

    public void dfs2(Map<String, Map<String, Double>> graph, String u, double w, Set<String> visited) {
        if (visited.contains(u)) return;
        visited.add(u);
        if(!graph.containsKey(u)) return ;
        for (String v : graph.get(u).keySet()) {
            if (!visited.contains(v)) {
                if (v.equals(initialCurrency)) {
                    //System.out.println(u+" "+v);
                    maxi = Math.max(maxi, w * graph.get(u).get(v));
                }
                dfs2(graph, v, w * graph.get(u).get(v), visited);
            }
        }
    }

    public double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        this.initialCurrency = initialCurrency;
        Map<String, Map<String, Double>> graph1 = new HashMap<>();
        Map<String, Map<String, Double>> graph2 = new HashMap<>();

        // Build graph1
        for (int i = 0; i < pairs1.size(); i++) {
            String u = pairs1.get(i).get(0);
            String v = pairs1.get(i).get(1);
            double w = rates1[i];
            graph1.putIfAbsent(u, new HashMap<>());
            graph1.putIfAbsent(v, new HashMap<>());
            graph1.get(u).put(v, w);
            graph1.get(v).put(u, 1 / w);
        }

        // Build graph2
        for (int i = 0; i < pairs2.size(); i++) {
            String u = pairs2.get(i).get(0);
            String v = pairs2.get(i).get(1);
            double w = rates2[i];
            graph2.putIfAbsent(u, new HashMap<>());
            graph2.putIfAbsent(v, new HashMap<>());
            graph2.get(u).put(v, w);
            graph2.get(v).put(u, 1 / w);
        }
        // Perform DFS on graph1 to collect currency pairs
        Set<String> visited = new HashSet<>();
        dfs1(graph1, initialCurrency, 1.0d, visited);

        // System.out.println(graph1);
        // System.out.println(graph2);
        // System.out.println(currencies);
        // Reset visited set for graph2 traversal
        visited.clear();

        // Traverse graph2 and compute maximum amount
        for (List<Object> pair : currencies) {
            String u = (String) pair.get(0);
            double w = (double) pair.get(1);
            //System.out.println(u+" "+w);
            dfs2(graph2, u, w, visited);
            visited.clear();
        }

        return maxi;
    }
}
