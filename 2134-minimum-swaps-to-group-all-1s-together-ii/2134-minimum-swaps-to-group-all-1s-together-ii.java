class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int countOnes = 0;
        
        for (int num : nums) {
            if (num == 1) countOnes++;
        }
        
        if (countOnes == 0) return 0;
        
        int maxOnesInWindow = 0;
        int currentOnesInWindow = 0;
        
        for (int i = 0; i < countOnes; i++) {
            if (nums[i] == 1) currentOnesInWindow++;
        }
        
        maxOnesInWindow = currentOnesInWindow;
        
        for (int i = countOnes; i < n + countOnes; i++) {
            if (nums[i % n] == 1) currentOnesInWindow++;
            if (nums[(i - countOnes) % n] == 1) currentOnesInWindow--;
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnesInWindow);
        }
        
        return countOnes - maxOnesInWindow;
    }
}