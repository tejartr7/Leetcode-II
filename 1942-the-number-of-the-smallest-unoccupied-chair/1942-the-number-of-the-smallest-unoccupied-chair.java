class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<tuple> arrivals = new PriorityQueue<>((a, b) -> a.y - b.y);
        PriorityQueue<pair> departures = new PriorityQueue<>((a, b) -> a.y - b.y);
        
        for (int i = 0; i < times.length; i++) {
            arrivals.offer(new tuple(i, times[i][0], times[i][1]));
        }
        
        TreeSet<Integer> availableChairs = new TreeSet<>();
        for (int i = 0; i <= times.length; i++) availableChairs.add(i);
        
        while (!arrivals.isEmpty()) {
            while (!departures.isEmpty() && departures.peek().y <= arrivals.peek().y) {
                pair leaveEvent = departures.poll();
                availableChairs.add(leaveEvent.x);
            }
            
            tuple arrivalEvent = arrivals.poll();
            int friendIndex = arrivalEvent.x;
            int assignedChair = availableChairs.pollFirst();
            
            if (friendIndex == targetFriend) return assignedChair;
            
            departures.offer(new pair(assignedChair, arrivalEvent.z));
        }
        
        return -1;
    }
}

class tuple {
    int x, y, z;
    tuple(int a, int b, int c) {
        x = a;
        y = b;
        z = c;
    }
}

class pair {
    int x, y;
    pair(int a, int b) {
        x = a;
        y = b;
    }
}
