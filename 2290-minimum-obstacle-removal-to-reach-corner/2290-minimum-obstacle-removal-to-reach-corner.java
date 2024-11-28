class tuple {
    int x, y, cnt;
    tuple(int a, int b, int c) {
        x = a;
        y = b;
        cnt = c;
    }
}

class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        PriorityQueue<tuple> pq = new PriorityQueue<>((a, b) -> a.cnt - b.cnt);
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, 1000_000_000);
        }
        dp[0][0] = grid[0][0];
        pq.offer(new tuple(0, 0, dp[0][0]));
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!pq.isEmpty()) {
            tuple top = pq.poll();
            int x = top.x, y = top.y, cnt = top.cnt;
            if (x == m - 1 && y == n - 1) return cnt;
            
            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (valid(nx, ny, m, n)) {
                    int newCnt = cnt + grid[nx][ny];
                    if (dp[nx][ny] > newCnt) {
                        dp[nx][ny] = newCnt;
                        pq.offer(new tuple(nx, ny, newCnt));
                    }
                }
            }
        }
        return -1;
    }

    private boolean valid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}