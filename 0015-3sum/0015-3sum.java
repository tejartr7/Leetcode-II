class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
     Arrays.sort(nums);
        int i,l=nums.length;
        List<List<Integer>> res=new ArrayList<>();
        for(i=0;i<l;i++)
        {
            int j=i+1;
            int k=l-1;
            if(i>0 && nums[i]==nums[i-1])
                continue;
            while(j<k)
            {
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0)
                {   List<Integer> a=new ArrayList<>();
                    a.add(nums[i]);
                    a.add(nums[j]);
                    a.add(nums[k]);
                    res.add(a);
                   
                    while(k>j && nums[k]==nums[k-1])
                     k--;
                    k--;
                    
                 }
                else if(sum<0) j++;
                else
                    k--;
                    
            }
          
        }
          return res;
    }
}