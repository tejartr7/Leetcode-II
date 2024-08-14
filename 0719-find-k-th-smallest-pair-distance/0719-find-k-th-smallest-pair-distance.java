public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n - 1] - nums[0];
        int ans=0;
        while (left <=right) {
            int mid = left + (right - left) / 2;
            if (countPairs(nums, mid) >= k) {
                right = mid-1;
                ans=mid;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private int countPairs(int[] nums, int maxDist) {
        int count = 0;
        int n = nums.length;
        int left = 0;

        for (int right = 0; right < n; right++) {
            while (nums[right] - nums[left] > maxDist) {
                left++;
            }
            count += right - left;
        }

        return count;
    }
}