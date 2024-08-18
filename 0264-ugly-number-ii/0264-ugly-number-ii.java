class Solution {
    public int nthUglyNumber(int n) {
        // Min-Heap to store the ugly numbers
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        
        heap.add(1L);
        seen.add(1L);
        
        long currentUgly = 1;
        for (int i = 0; i < n; i++) {
            currentUgly = heap.poll();
            
            // Generate next ugly numbers
            if (!seen.contains(currentUgly * 2)) {
                heap.add(currentUgly * 2);
                seen.add(currentUgly * 2);
            }
            if (!seen.contains(currentUgly * 3)) {
                heap.add(currentUgly * 3);
                seen.add(currentUgly * 3);
            }
            if (!seen.contains(currentUgly * 5)) {
                heap.add(currentUgly * 5);
                seen.add(currentUgly * 5);
            }
        }
        
        return (int) currentUgly;
    }
}
