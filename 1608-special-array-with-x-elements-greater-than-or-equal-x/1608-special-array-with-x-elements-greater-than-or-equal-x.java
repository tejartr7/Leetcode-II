class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] count = new int[n + 1]; // count array to hold counts of numbers greater than or equal to each index
        
        // Fill the count array
        for (int num : nums) {
            if (num >= n) {
                count[n]++;
            } else {
                count[num]++;
            }
        }
        
        // Find the prefix sums
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += count[i];
            if (total == i) {
                return i;
            }
        }
        
        // If no such x exists, return -1
        return -1;
    }
}