class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] count = new int[1001];
        
        // Fill the count array
        for (int num : nums) {
            count[num]++;
        }
        
        // Find the prefix sums
        int total = 0;
        for (int i = 1000; i >= 0; i--) {
            total += count[i];
            if (total == i) {
                return i;
            }
        }
        
        // If no such x exists, return -1
        return -1;
    }
}