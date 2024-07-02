class Solution {
public:
    int minimumDifference(vector<int>& nums, int k) {
        int n= nums.size();
        int ans=INT_MAX;
        for(int i=0;i<n;i++){
            int curr=nums[i];
            ans=min(ans, abs(curr-k));
            int prev=0;
            int j=i-1;
            while(j>=0 && curr!=prev){
                curr|=nums[j];
                prev|=nums[j];
                ans=min(ans, abs(curr-k));
                j--;
            }
        }
        return ans;
    }
};