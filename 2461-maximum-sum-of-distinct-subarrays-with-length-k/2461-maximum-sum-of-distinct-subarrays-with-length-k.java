import java.util.*;
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        int i=0,j=0;
        int n=nums.length;
        long sum=0,max=0;
        while(j<n)
        {
            while(set.size()==k || set.contains(nums[j]))
            {
                sum-=nums[i];
                set.remove(nums[i]);
                i++;
            }
            sum+=nums[j];
            set.add(nums[j]);
            if(set.size()==k)
            max=Math.max(max,sum);
            j++;
        }
        return max;
    }
}