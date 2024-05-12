class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        int n = points.length;
        for (int i = 0; i < n; i++) {
            points[i][0] = Math.abs(points[i][0]);
            points[i][1] = Math.abs(points[i][1]);
        }
        int left = 0, right = 1000000000, result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            HashMap<Character, Integer> charCount = new HashMap<>();
            boolean isValid = true;
            for (int i = 0; i < n; i++) {
                if (points[i][0] <= mid && points[i][1] <= mid)
                    charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
            }

            for (int count : charCount.values()) {
                if (count > 1) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                result = mid;
                left = mid + 1;
            } else
                right = mid - 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (points[i][0] <= result && points[i][1] <= result) {
                count++;
            }
        }
        return count;
    }
}