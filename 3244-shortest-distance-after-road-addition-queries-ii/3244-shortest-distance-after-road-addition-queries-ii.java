class Solution {
        public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        var ans = new int[queries.length];
        var map = new HashMap<Integer, Integer>();

        //Create a map to store the largest node reachable from a node
        //Initially all nodes will have only one node reachable i.e. the next node
        for (int i = 0; i < n - 1; i++) {
            map.put(i, i + 1);
        }

        for (int i = 0; i < queries.length; i++) {
            var u = queries[i][0];
            var v = queries[i][1];

            //Check if `u` node exists if it doesn't it means the node is already removed, so no point considering this query 
            //If `u` node exists but `v` node is less that the value of the map then this is not largest node reachable from u, so no point considering this query 
            if (!map.containsKey(u)||map.get(u) >= v) {
                ans[i] = map.size();
                continue;
            }

            //If `v` node is larger than the value of map then get rid off nodes between of `u` and `v`
            var j = map.get(u);
            while (j < v) {
                j = map.remove(j);
            }
            map.put(u, v);


            //We got rid off useless nodes so the size of map is answer 
            ans[i] = map.size();
        }
        
        return ans;
    }
}