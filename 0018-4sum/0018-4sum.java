class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int i,j,k,l;
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        for(i=0;i<n-2;i++)
        {
            if(i>0 && nums[i]==nums[i-1])
                    continue;
            for(j=i+1;j<n;j++)
            {
                k=j+1;
                l=n-1;
                
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;
                else
                {
                    while(k<l)
                    {
                        long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                        if(sum==target)
                        {
                            List<Integer> temp=new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);
                            list.add(new ArrayList<>(temp));
                            while(k<n&& nums[k-1]==nums[k])
                                k++;
                            while(l>k && nums[l-1]==nums[l])
                            l--;
                            l--;
                        }
                        else if(sum<target)
                        {
                            k++;
                        }
                        else 
                            l--;
                    }
                }
            }
        }
        return list;
    }
}