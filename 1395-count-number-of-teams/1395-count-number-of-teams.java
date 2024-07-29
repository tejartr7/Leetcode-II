class Solution {
    public int numTeams(int[] nums) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int leftSmall = 0, leftLarge = 0, rightSmall = 0, rightLarge = 0;

            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    leftSmall++;
                } else if (nums[j] > nums[i]) {
                    leftLarge++;
                }
            }

            for (int k = i + 1; k < n; k++) {
                if (nums[k] < nums[i]) {
                    rightSmall++;
                } else if (nums[k] > nums[i]) {
                    rightLarge++;
                }
            }

            ans += leftSmall * rightLarge + leftLarge * rightSmall;
        }

        return ans;
    }
}