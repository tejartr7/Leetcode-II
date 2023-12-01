class Solution {
    public List<Integer> spiralOrder(int[][] a) {
        int amin = 0, amax = a.length - 1, bmin = 0, bmax = a[0].length - 1;
        List<Integer> list = new ArrayList<>();
        
        while (amin <= amax && bmin <= bmax) {
            // Traverse from left to right
            for (int j = bmin; j <= bmax; j++) {
                list.add(a[amin][j]);
            }
            amin++;

            // Traverse from top to bottom
            for (int i = amin; i <= amax; i++) {
                list.add(a[i][bmax]);
            }
            bmax--;

            // Traverse from right to left
            if (amin <= amax) {
                for (int j = bmax; j >= bmin; j--) {
                    list.add(a[amax][j]);
                }
                amax--;
            }

            // Traverse from bottom to top
            if (bmin <= bmax) {
                for (int i = amax; i >= amin; i--) {
                    list.add(a[i][bmin]);
                }
                bmin++;
            }
        }
        return list;
    }
}
