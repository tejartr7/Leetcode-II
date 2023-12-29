class Solution {
    int dp[][];
    public int helper(int idx, int d, int[] job) {
        int n = job.length;
        if (idx >= n) {
            if (d == 0) {
                return 0;
            }
            return 1000_000_000;
        }
        if(d<0)
            return 1000_000_000;
        if(dp[idx][d]!=-1)
            return dp[idx][d];
        int ans = 1000_000_000;
        int max = job[idx];
        for (int i = idx; i < n; i++) {
            max = Math.max(max, job[i]);
            int q = max + helper(i + 1, d - 1, job);
            if(q<1000_000_000)
            ans = Math.min(ans, q);
        }
        return dp[idx][d]=ans;
    }

    public int minDifficulty(int[] job, int d) {
        if(job.length<d)
            return -1;
        dp=new int[job.length][d+1];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        int result = helper(0, d, job);
        return result >= 1000_000_000 ? -1 : result;
    }
}
