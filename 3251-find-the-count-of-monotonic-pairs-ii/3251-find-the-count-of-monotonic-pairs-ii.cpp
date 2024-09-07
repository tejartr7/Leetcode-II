const int N = 2001;
const int M = 1e9+7;

class Solution {
public:
    int countOfPairs(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp(N, 1);   // dp[i+1]
        
        for (int i = n-1; i >= 0; i --) {
            vector<int> new_dp (N, 0);
            
            vector<int> prefix (N, 0);
            prefix[0] = dp[0];
            for (int j = 1; j < N; j ++) prefix[j] = (prefix[j-1] + dp[j]) % M;
            
            for (int prv1 = 0; prv1 <= 2000; prv1 ++) {
                int prv2 = (i > 0)? nums[i-1]-prv1 : 1e9;
                if (prv2 < 0) break;
                
                int l = max(prv1, nums[i] - prv2);
                int r = nums[i];
                
                if (l <= r) new_dp[prv1] = (prefix[r] - (l > 0? prefix[l-1] : 0) + M) % M;
            }
            dp = new_dp;
        }        
        return dp[0];
    }
};