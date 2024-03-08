class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int maxi=0;
        for(int x:nums)
          { map.put(x,map.getOrDefault(x,0)+1);
            maxi=Math.max(maxi,map.get(x)); 
          }
        int ans=0;
       
        for(int x:map.keySet())
        {
            
            if(map.get(x)==maxi)
            {
                ans+=map.get(x);
            }
        }
        return ans;
        
    }
}