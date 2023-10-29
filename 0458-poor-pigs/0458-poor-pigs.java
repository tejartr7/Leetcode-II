class Solution {
   public int poorPigs(int buckets, int m, int p) {
    int t = p/m + 1;
    // t^x >= buckets ==> x
    // <=> log(buckets) base t
    int x = 0;
    while (Math.pow(t, x) < buckets) x++;
    return x;
    }
}