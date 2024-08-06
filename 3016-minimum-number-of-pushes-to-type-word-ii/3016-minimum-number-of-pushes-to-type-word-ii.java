import java.util.*;

class Pair {
    String x;
    int y;
    
    Pair(String a, int b) {
        x = a;
        y = b;
    }
}

class Solution {
    public int minimumPushes(String word) {
        Queue<Pair> queue = new LinkedList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.y - a.y);
        
        // Initialize the queue with pairs (i, 1) for i from 0 to 7
        for (int i = 0; i < 8; i++) {
            queue.offer(new Pair(String.valueOf(i), 1));
        }
        
        // Count frequency of each character in the word
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : word.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        
        // Populate the priority queue with the character frequencies
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.offer(new Pair(String.valueOf(entry.getKey()), entry.getValue()));
        }
        
        int totalPushes = 0;
        
        // Process the priority queue
        while (!pq.isEmpty()) {
            Pair top1 = pq.poll();
            Pair top2 = queue.poll();
            totalPushes += (top1.y * top2.y);
            queue.offer(new Pair(top2.x, top2.y + 1));
        }
        
        return totalPushes;
    }
}