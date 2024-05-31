class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0, y = 0;
        int xor = 0;
        
        for (int num : nums) {
            xor ^= num;
        }
        
        int rightmostSetBit = xor & -xor;
        
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
