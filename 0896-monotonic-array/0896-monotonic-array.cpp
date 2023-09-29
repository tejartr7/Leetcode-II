class Solution {
public:
    bool increase(vector<int>& nums)
    {
        int i,n=nums.size();
        int x=nums[0];
        for(i=1;i<n;i++)
        {
            if(x>nums[i])
                return false;
            x=nums[i];
        }
        return true;
    }
     bool decrease(vector<int>& nums)
    {
        int i,n=nums.size();
        int x=nums[0];
        for(i=1;i<n;i++)
        {
            if(x<nums[i])
                return false;
            x=nums[i];
        }
        return true;
    }
    bool isMonotonic(vector<int>& nums) {
        bool a=increase(nums);
        bool b=decrease(nums);
        return a|b;
    }
};