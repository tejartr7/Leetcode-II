class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;

        // Priority queue based on the incremental gain
        PriorityQueue<double[]> pq = new PriorityQueue<>(
            (a, b) -> Double.compare(
                ((b[0] + 1) / (b[1] + 1)) - (b[0] / b[1]),
                ((a[0] + 1) / (a[1] + 1)) - (a[0] / a[1])
            )
        );

        // Initialize the queue with each class
        for (int[] cls : classes) {
            pq.add(new double[]{cls[0], cls[1]});
        }

        // Distribute extra students
        while (extraStudents-- > 0) {
            double[] top = pq.poll();
            top[0]++; // Increment passed students
            top[1]++; // Increment total students
            pq.add(top); // Recalculate and reinsert into the queue
        }

        // Calculate the final average pass ratio
        double ans = 0.0;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            ans += top[0] / top[1];
        }

        return ans / n;
    }
}
