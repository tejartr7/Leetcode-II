class Solution {
    public int helper(int x,int s,Map<Integer,Integer> map,int c)
    {
        int ans=0;
        int k=0;
        while(c>=0)
        {
            if(map.containsKey(x+c*s))
            {
                ans+=map.get(x+c*s);
            }
            c--;
        }
        return ans;
    }
    public int destroyTargets(int[] nums, int k) {
        int i,j,n=nums.length;
        int maxi=0;
        Arrays.sort(nums);
        Map<Integer,Integer> map=new HashMap<>();
        for(int x:nums)
        {
            maxi=Math.max(maxi,x);
            map.put(x%k,map.getOrDefault(x%k,0)+1);
        }
        int ans=0;
        int max=0;
        for(i=0;i<n;i++)
        {
            int x=map.get(nums[i]%k);
            if(max<x)
            {
                max=x;
                ans=nums[i];
            }
            else if(max==x)
            {
                ans=Math.min(ans,nums[i]);
            }
        }
        return ans;
    }
}