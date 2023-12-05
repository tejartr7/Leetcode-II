class Solution {
    public int numberOfMatches(int n) {
        int ans=0;
        if(n==1)
            return 0;
        ans+=n/2;
        ans+=numberOfMatches((n+1)/2);
        return ans;
    }
}