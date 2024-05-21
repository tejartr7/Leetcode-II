class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res=new ArrayList<>();
        res.add(new ArrayList<>());
        int i,j;
        int n=nums.length;
        for(i=0;i<n;i++)
        {
            int l=res.size();
            for(j=0;j<l;j++)
            {
                List<Integer> temp=new ArrayList(res.get(j));
                temp.add(nums[i]);
                res.add(temp);
            }
        }
        return res;
    
    }
}