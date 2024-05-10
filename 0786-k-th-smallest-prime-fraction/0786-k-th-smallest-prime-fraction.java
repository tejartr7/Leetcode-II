import java.util.PriorityQueue;

class tuple {
    int a, b;
    double c;

    tuple(int x, int y, double z) {
        a = x;
        b = y;
        c = z;
    }
}

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<tuple> pq = new PriorityQueue<>((x, y) -> Double.compare(y.c, x.c)); // Corrected lambda expression
        int i, j, n = arr.length;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (i != j) {
                    double fraction = (double) arr[i] / (double) (arr[j]); // Renamed the variable to 'fraction'
                    pq.offer(new tuple(arr[i], arr[j], fraction));
                    if (pq.size() > k) {
                        pq.poll();
                    }
                }
            }
        }
        if (pq.size() == 0)
            return new int[]{};
        tuple result = pq.peek();
        return new int[]{result.a, result.b};
    }
}
