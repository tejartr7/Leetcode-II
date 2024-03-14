class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int i,j,n=nums.length;
        int sum=0;
        int cnt=0;
        i=0;j=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(i=0;i<n;i++)
        {
            sum+=nums[i];
            if(map.containsKey(sum-goal))
            {
                cnt+=map.get(sum-goal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}