class Solution {
public:
    vector<int> sortArrayByParity(vector<int>& nums) {
        vector<int> ans;
        for(auto x:nums)
            if(x%2==0)
                ans.push_back(x);
        for(auto x:nums)
            if(x%2==1)
                ans.push_back(x);
        return ans;
    }
};