class Solution {
    public int robotSim(int[] nums, int[][] arr) {
        Map<Integer, TreeSet<Integer>> map1 = new HashMap<>();
        Map<Integer, TreeSet<Integer>> map2 = new HashMap<>();
        int m = nums.length, maxi = 0;

        // Store obstacles in the maps
        for (int[] x : arr) {
            int a = x[0], b = x[1];
            if (!map1.containsKey(a)) map1.put(a, new TreeSet<>());
            if (!map2.containsKey(b)) map2.put(b, new TreeSet<>());
            map1.get(a).add(b);
            map2.get(b).add(a);
        }

        int a = 0, b = 0; // Robot's starting position
        boolean north = true, east = false, south = false, west = false;

        for (int i = 0; i < m; i++) {
            int x = nums[i];
            if (x == -1) { // Turn right
                if (north) { north = false; east = true; }
                else if (east) { east = false; south = true; }
                else if (south) { south = false; west = true; }
                else { west = false; north = true; }
            } else if (x == -2) { // Turn left
                if (north) { north = false; west = true; }
                else if (west) { west = false; south = true; }
                else if (south) { south = false; east = true; }
                else { east = false; north = true; }
            } else { // Move forward
                if (north) {
                    int p = b + x;
                    Integer q = map1.getOrDefault(a, new TreeSet<>()).ceiling(b + 1);
                    if (q == null || q > p) {
                        b = p;
                    } else {
                        b = q - 1;
                    }
                } else if (east) {
                    int p = a + x;
                    Integer q = map2.getOrDefault(b, new TreeSet<>()).ceiling(a + 1);
                    if (q == null || q > p) {
                        a = p;
                    } else {
                        a = q - 1;
                    }
                } else if (south) {
                    int p = b - x;
                    Integer q = map1.getOrDefault(a, new TreeSet<>()).floor(b - 1);
                    if (q == null || q < p) {
                        b = p;
                    } else {
                        b = q + 1;
                    }
                } else { // West
                    int p = a - x;
                    Integer q = map2.getOrDefault(b, new TreeSet<>()).floor(a - 1);
                    if (q == null || q < p) {
                        a = p;
                    } else {
                        a = q + 1;
                    }
                }
            }
            // Calculate maximum Euclidean distance
            maxi = Math.max(maxi, a * a + b * b);
        }
        return maxi;
    }
}
