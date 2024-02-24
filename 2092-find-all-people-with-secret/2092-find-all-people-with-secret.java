class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int first) {
        Arrays.sort(meetings,(a,b)->a[2]-b[2]);
        UF uf = new UF(n);
        uf.union(0, first);
        int i = 0;
        while (i < meetings.length) {
            int curTime = meetings[i][2];
            Set<Integer> pool = new HashSet<>();
            
            while (i < meetings.length && curTime == meetings[i][2]) {
                int[] currentMeeting = meetings[i];
                uf.union(currentMeeting[0], currentMeeting[1]);
                pool.add(currentMeeting[0]);
                pool.add(currentMeeting[1]);
                i++;
            }
            for (int j : pool) if (!uf.connected(0, j)) uf.reset(j);
        }
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < n; j++) if (uf.connected(j,0)) ans.add(j);
        return ans;
    }
}
class UF {
        int[] parent, rank;
		
        public UF(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ)
                return;

            if (rank[rootP] < rank[rootQ]) {
                parent[rootP] = rootQ;
            } else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
        }
        
        public int find(int p) {
            while (parent[p] != p) {
                p = parent[parent[p]];
            }
            return p;
        }
        
        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }
        
        public void reset(int p) {
            parent[p] = p;
            rank[p] = 0;
        }
}