class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;
        
        Arrays.sort(points, Comparator.<int[]>comparingInt(a -> a[0])
                                      .thenComparingInt(a -> -a[1]));

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (help(points, n, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    boolean help(int[][] points, int n, int i, int j) {
        int upperLeftX = points[i][0];
        int upperLeftY = points[i][1];
        int lowerRightX = points[j][0];
        int lowerRightY = points[j][1];
        
        if(upperLeftX>lowerRightX || upperLeftY<lowerRightY) return false;

        for (int k = 0; k < n; k++) {
            if (k != i && k != j) {
                if (points[k][0] >= upperLeftX && points[k][0] <= lowerRightX &&
                    points[k][1] <= upperLeftY && points[k][1] >= lowerRightY) {
                    return false;
                }
            }
        }

        return true;
    }
}
