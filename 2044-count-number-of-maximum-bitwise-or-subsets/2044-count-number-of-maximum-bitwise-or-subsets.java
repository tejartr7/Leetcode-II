class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int res[]= new int[1];
        int target = 0;
        res[0]=0;
        for (int num : nums)
            target |= num;
        dfs(nums, res,0, 0,target);
        return res[0];
    }
    public void dfs(int[] nums, int res[],int idx,int mask,int target) {
        if (mask == target) {
            res[0]++;
        }
        
        for (int i = idx; i < nums.length; i++)
            dfs(nums, res,i + 1, mask | nums[i],target);
    }
}