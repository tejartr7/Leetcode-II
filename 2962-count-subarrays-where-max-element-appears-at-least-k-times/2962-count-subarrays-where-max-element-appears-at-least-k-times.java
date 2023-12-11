class Solution {
     public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        int i = 0, j = 0, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int maxi = 0;

        for (int x : nums) {
            maxi = Math.max(maxi, x);
        }

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.getOrDefault(maxi, 0) >= k && nums[j] == maxi) {
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }

            ans += j - i + 1;
            j++;
        }

        long total = (long) n * (n + 1) / 2;
        return total - ans;
    }
}