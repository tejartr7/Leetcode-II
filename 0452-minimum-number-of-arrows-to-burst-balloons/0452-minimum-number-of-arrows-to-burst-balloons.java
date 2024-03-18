import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        int i, j, n = points.length;
        Arrays.sort(points, (int[] p1, int[] p2)->{
		    // Don't use p1[1 ] - p2[1]. It may overflow 
            return p1[1] < p2[1] ? -1 : 1; 
        });
        int count = 1;
        int min = points[0][1];
        for (i = 1; i < n; i++) {
            if (points[i][0] > min) {
                count++;
                min = points[i][1];
            }
        }
        return count;
    }
}