class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> ans=new HashMap<>();
        int i,n=nums.length;
        for(i=0;i<n;i++)
        {
            ans.put(nums[i],ans.getOrDefault(nums[i],0)+1);
        }
        List<Integer>res=new ArrayList<>();
        for(int k:ans.keySet())
        {
            int p=ans.get(k);
            if(p>n/3)
                res.add(k);
        }
        return res;
    }
}