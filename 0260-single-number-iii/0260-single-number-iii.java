class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0, y = 0;
        int xor = 0;
        
        // Step 1: XOR all elements to get xor of the two unique numbers
        for (int num : nums) {
            xor ^= num;
        }
        
        // Step 2: Find the rightmost set bit in the xor result
        int rightmostSetBit = xor & -xor;
        
        // Step 3: Divide numbers into two groups and XOR them separately
        for (int num : nums) {
            if ((num & rightmostSetBit) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        
        return new int[]{x, y};
    }
}
