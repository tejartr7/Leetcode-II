class Solution {
    int i, j, n, k;
    int dp[][][];
    int nums[];
    public int solve(int i, int op1, int op2) {
    if (i == n) {
        return 0;
    }
    if (dp[i][op1][op2] != -1) {
        return dp[i][op1][op2];
    }
    int ans = 1000_000_000;

    if (op1 > 0) {
        int modified = (nums[i] + 1) / 2;
        ans = Math.min(ans, solve(i + 1, op1 - 1, op2) + (nums[i]+1)/2);
    }
    if (op2 > 0 && nums[i] >= k) {
        int modified = nums[i] - k;
        ans = Math.min(ans, solve(i + 1, op1, op2 - 1) +(nums[i]-k));
    }
    ans = Math.min(ans, nums[i]+solve(i + 1, op1, op2));
    if(op1>0){
        int temp=(nums[i]+1)/2;
        if(op2>0 && temp>=k){
            temp-=k;
            ans = Math.min(ans, solve(i + 1, op1 - 1, op2 - 1)+temp);
        }
    }

    if(op2>0 && nums[i]>=k){
        int temp=nums[i]-k;
        if(op1>0){
            temp=(temp+1)/2;
            int modified = nums[i] - k;
            ans = Math.min(ans, solve(i + 1, op1 - 1, op2 - 1) + temp);
        }
    }
    return dp[i][op1][op2] = ans;
}


    public int minArraySum(int[] nums, int k, int op1, int op2) {
        this.n = nums.length;
        this.k = k;
        this.nums=nums;
        dp = new int[n + 1][op1 + 1][op2 + 1];
        for (int x[][] : dp) {
            for (int y[] : x) {
                Arrays.fill(y, -1);
            }
        }
        return solve(0, op1, op2);
    }
}