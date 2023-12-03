class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int ans=0;
        int curr=1;
        for(int x:coins)
        {
            while(curr<x)
            {
                curr*=2;
                ans++;
            }
            curr+=x;
            if(curr>target)
                break;
        }
        while(curr<=target)
        {
            curr*=2;
            ans++;
        }
        return ans;
    }
}