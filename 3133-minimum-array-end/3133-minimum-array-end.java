class Solution {
    public long minEnd(int n, long x) {
        long ans=x;
        if(n==1) return x;
        n--;
        for(int i=0;i<64;i++){
            if((x>>i)%2==0){
                if((n&1)==1)
                ans|=(1L<<i);
                n>>=1;
            }
        }
        return ans;
    }
}