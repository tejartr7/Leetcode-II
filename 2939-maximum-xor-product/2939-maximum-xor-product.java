class Solution {
    public int maximumXorProduct(long a, long b, int n) {
        int mod = 1000000007;
        long res = 0;

        for (long x = 1L << (n - 1); x > 0; x >>= 1) {
            if ((Math.min(a,b)&x) == 0) {
                a ^= x;
                b ^= x;
            }
        }

        res = (a % mod) * (b % mod) % mod;
        return (int) res;
    }
}
