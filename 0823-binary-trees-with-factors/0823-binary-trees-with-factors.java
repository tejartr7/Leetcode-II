class Solution {
    public int numFactoredBinaryTrees(int[] nums) {
        Map<Integer,Long> dp=new HashMap<>();
        long mod=1000_000_007L;
        int i,j,n=nums.length;
        Arrays.sort(nums);
        for(i=0;i<n;i++)
        {
            dp.put(nums[i],1L);
            for(j=0;j<i;j++)
            {
                if(nums[i]%nums[j]==0 && dp.containsKey(nums[i]/nums[j]))
                {
                   dp.put(nums[i], dp.get(nums[i]) + (dp.get(nums[j]) * dp.get(nums[i] / nums[j])));
                }
            }
        }
        long res=0;
        for(int x:dp.keySet())
            res+=dp.get(x);
        return (int)(res%mod);
    }
}