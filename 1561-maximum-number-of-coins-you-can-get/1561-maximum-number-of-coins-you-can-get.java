class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int i,j,n=piles.length;
        i=0;j=n-1;
        int ans=0;
        while(i<j)
        {
            ans+=piles[j-1];
            j-=2;
            i+=1;
        }
        return ans;
    }
}