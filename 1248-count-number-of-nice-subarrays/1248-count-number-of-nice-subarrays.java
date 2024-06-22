class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans=0;
        int count=0,sum=0;
        int i,j,n=nums.length;
        for(i=0;i<n;i++)
        {
            nums[i]%=2;
        }
        i=0;j=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(i=0;i<n;i++)
        {
            sum+=nums[i];
            if(map.containsKey(sum-k))
                ans+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}