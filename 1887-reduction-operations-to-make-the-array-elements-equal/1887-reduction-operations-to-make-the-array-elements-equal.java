import java.util.Arrays;

class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums); // Sort the array in ascending order
        int cnt = 0, cur = 0, n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                cur++; // Increment cur for each distinct element
            }
            cnt += cur; // Add cur to cnt for each element (including duplicates)
        }

        return cnt;
    }
}
