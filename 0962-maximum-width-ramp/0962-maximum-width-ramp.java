class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int minIndex = pairs[0][1];
        int maxRampWidth = 0;

        for (int i = 1; i < n; i++) {
            int idx = pairs[i][1];
            maxRampWidth = Math.max(maxRampWidth, idx - minIndex);
            minIndex = Math.min(minIndex, idx);
        }

        return maxRampWidth;
    }
}
