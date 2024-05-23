class Solution {
    int k;
    public int beautifulSubsets(int[] nums, int k) {
        this.k=k;
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<>();
        backTrack(0,nums,new ArrayList<>(),list);
        return list.size();
    }
    public void backTrack(int index,int []nums,List<Integer> curr,List<List<Integer>> list)
    {
        if(index>=nums.length)
        {
            if(curr.size()>0)
                list.add(new ArrayList<>(curr));
            return ;
        }
        if(!curr.contains(nums[index]-k))
        {
            curr.add(nums[index]);
            backTrack(index+1,nums,curr,list);
            curr.remove(curr.size()-1);
        }
        backTrack(index+1,nums,curr,list);
    }
}