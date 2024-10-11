class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int[][] events = new int[2 * n][3];
        boolean[] chairs = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            events[2 * i] = new int[]{times[i][0], 1, i};  // arrival
            events[2 * i + 1] = new int[]{times[i][1], -1, i}; // departure
        }
        
        Arrays.sort(events, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        
        int[] chairMap = new int[n];
        Arrays.fill(chairMap, -1);

        for (int[] event : events) {
            int time = event[0];
            int type = event[1];
            int friend = event[2];

            if (type == 1) {  // Arrival
                int assignedChair = 0;
                while (chairs[assignedChair]) assignedChair++;
                
                chairs[assignedChair] = true;
                chairMap[friend] = assignedChair;
                
                if (friend == targetFriend) return assignedChair;
            } else {  // Departure
                chairs[chairMap[friend]] = false;
            }
        }
        
        return -1;
    }
}
