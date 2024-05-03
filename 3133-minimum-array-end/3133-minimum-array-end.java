class Solution {
    public long minEnd(int n, long x) {
        long ans = x;
        if (n == 1) return x;
        n -= 1;
        for (int i = 0; i < 64; i++) {
            if (n <= 0)
                break;
            long k = (x >> i) % 2;
            if (k != 1) {
                long t = n % 2;
                ans |= (t << i);
                n /= 2;
            }
        }
        return ans;
    }
}
