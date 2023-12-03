class Solution {
public:
    int minimumAddedCoins(vector<int>& coins, int target) {
        sort(coins.begin(),coins.end());
        long long int ans=0,x=1;
        for(auto i:coins){
            while(i>x){
                ans++;
                x=x*2;
            }
            x+=i;
            if(x>target)
                break;
        }
        while(x<=target){
            ans++;
            x=x*2;
        }
        return ans;
    }
};