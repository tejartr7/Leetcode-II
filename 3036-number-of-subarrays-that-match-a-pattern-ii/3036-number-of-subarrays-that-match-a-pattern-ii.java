class Solution {
    int prime = 31;
    long mod = (long)1e9 + 7; 
    
    public boolean check(int[] window, int[] pat) {
        for (int i = 0; i < window.length; i++) {
            int temp = window[i] - (i > 0 ? window[i - 1] : 0);
            if (temp < 0 && pat[i] >= 0 || temp > 0 && pat[i] <= 0 || temp == 0 && pat[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    public int countMatchingSubarrays(int[] nums, int[] pat) {
        int n = nums.length;
        int m = pat.length;
        long[] window = new long[n];
        window[0] = nums[0];
        for (int i = 1; i < n; i++) {
            window[i] = (long)nums[i] - (long)nums[i - 1];
            if (window[i] < 0)
                window[i] = -1l;
            else if (window[i] > 0)
                window[i] = 1l;
        }
        
        long[] pre = new long[n];
        pre[0] = 0;
        long[] powers = new long[m + 1]; 
        powers[0] = 1;
        for (int i = 1; i <= m; i++) {
            powers[i] = (powers[i - 1] * prime) % mod;
        }
        
        for (int i = 1; i < n; i++) {
            pre[i] = (pre[i - 1] * prime + window[i]) % mod;
            if (pre[i] < 0) {
                pre[i] = (pre[i] + mod) % mod;
            }
        }
        
        long temp = 0;
        for (int i = 0; i < m; i++) {
            temp = (temp * prime + pat[i]) % mod;
            if (temp < 0) {
                temp = (temp + mod) % mod;
            }
        }
       
        int cnt = 0;
        for (int i = m; i < n; i++) {
            long x = (pre[i] - (i >= m ? pre[i - m] * powers[m] % mod : 0) + mod) % mod;
            if (x == temp)
                cnt++;
        }
        return cnt;
    }
}
