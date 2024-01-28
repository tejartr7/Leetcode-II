class Solution {
    public int maximumLength(int[] nums) {
        Arrays.sort(nums);
        int i,j,n=nums.length;
        Map<Integer,Integer>map=new HashMap<>();
        int ans=1;
        for(int x:nums)
            map.put(x,map.getOrDefault(x,0)+1);
        Set<Integer> vis=new HashSet<>();
        for(int x:map.keySet())
        {
            if(vis.contains(x))
                continue;
            if(x==1)
            {
                int temp=map.get(x);
                if(temp%2==0)
                    temp--;
                ans=Math.max(ans,temp);
                continue;
            }
            int temp=x;
            int curr=0;
            while(map.containsKey(temp) && map.get(temp)>1)
            {
                curr+=2;
                vis.add(temp);
                temp*=temp;
            }
            if(map.containsKey(temp) && map.get(temp)==1)
                curr++;
            else curr--;
            ans=Math.max(ans,curr);
        }
        return ans;
    }
}