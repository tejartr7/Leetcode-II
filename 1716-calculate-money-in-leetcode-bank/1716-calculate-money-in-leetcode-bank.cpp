class Solution {
public:
    int totalMoney(int n) {
        vector<int> ans(n+1,0);
        int i,j;
        ans[1]=1;
        int sum=1;
        for(i=2;i<=n;i++)
        {
            
            if((i-1)%7==0)
            {
                ans[i]=1+ans[i-7];
            }
            else ans[i]=1+ans[i-1];
            //cout<<i<<" "<<ans[i]<<"\n";
            sum+=ans[i];
        }
        return sum;
    }
};