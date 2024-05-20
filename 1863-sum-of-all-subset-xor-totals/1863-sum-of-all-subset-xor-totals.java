class Solution {
    public int subsetXORSum(int[] nums) {
        return XORSum(nums, 0, 0);
    }

    private int XORSum(int[] nums, int index, int currentXOR) {
        if (index == nums.length) return currentXOR;
        int withElement = XORSum(nums, index + 1, currentXOR ^ nums[index]);
        int withoutElement = XORSum(nums, index + 1, currentXOR);
        return withElement + withoutElement;
    }
}