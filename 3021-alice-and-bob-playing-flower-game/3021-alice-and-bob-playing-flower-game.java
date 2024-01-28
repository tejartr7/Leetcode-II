class Solution {
    public long flowerGame(int n, int m) {
        long ans=0;
        if(m==1 && n==1)
            return 0;
        ans+=(long)(n)*(long)m;
        ans/=2l;
        return ans;
    }
}