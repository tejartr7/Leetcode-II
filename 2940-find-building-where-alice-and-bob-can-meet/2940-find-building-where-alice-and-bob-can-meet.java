class Solution {
    public int[] leftmostBuildingQueries(int[] h, int[][] q) {
           for(int i = 0; i < q.length; i++) {
               if(q[i][0] > q[i][1]) {
                   int t = q[i][1];
                   q[i][1] = q[i][0];
                   q[i][0] = t;
               }
           }
           int[] res = new int[q.length];
           Arrays.fill(res, -1);
           ArrayList<Integer> idx = new ArrayList<>(q.length);
           for(int i = 0; i < q.length; i++) {
               if(q[i][0] == q[i][1] || h[q[i][0]] < h[q[i][1]]) {
                   res[i] = q[i][1];
               } else {
                   idx.add(i);
               }
           }
           Collections.sort(idx, (a,b) -> {
               return q[b][1] - q[a][1];
           });
           int adi = h.length-1;
           TreeMap<Integer, Integer> tm = new TreeMap<>();
           ArrayDeque<int[]> ad = new ArrayDeque<>();
          for(int i: idx) {
              int a = q[i][0];
              int b = q[i][1];
              System.out.println(a+" "+b);
              while(adi > b && adi >= 0) {
                  while(tm.size() > 0 && tm.firstKey() < h[adi]) {
                    tm.remove(tm.firstKey());
                  }
                  tm.put(h[adi], adi);
                  adi--;
              }
              Integer bidx = tm.higherKey(h[a]);
              if(bidx != null) {
                res[i] = tm.get(bidx);  
              }
          }
          return res;
    }
}