import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0, 0, 0});
        
        int[][][] minTime = new int[m][n][2];
        for (int[][] row : minTime)
            for (int[] cell : row)
                Arrays.fill(cell, Integer.MAX_VALUE);
        minTime[0][0][0] = 0;
        
        int[] dirs = {0, 1, 0, -1, 0};

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], x = curr[1], y = curr[2], moveCount = curr[3];
            
            if (x == m - 1 && y == n - 1) return time;
            
            int nextMoveTime = (moveCount % 2 == 0) ? 1 : 2;
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dirs[d], ny = y + dirs[d + 1];
                
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int waitTime = Math.max(time, moveTime[nx][ny]) + nextMoveTime;
                    int nextMoveCount = moveCount + 1;
                    
                    if (waitTime < minTime[nx][ny][nextMoveCount % 2]) {
                        minTime[nx][ny][nextMoveCount % 2] = waitTime;
                        pq.offer(new int[]{waitTime, nx, ny, nextMoveCount});
                    }
                }
            }
        }
        
        return -1;
    }
}
