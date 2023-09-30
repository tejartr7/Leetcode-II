class Solution {
    public int minOperations(int[] nums) {
        int cnt=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int x:nums)
            map.put(x,map.getOrDefault(x,0)+1);
      //  System.out.println(map);
        for(int x:map.keySet())
        {
            if(map.get(x)==1)
                return -1;
            else if(map.get(x)%3==0)
                cnt+=map.get(x)/3;
            else
            {
                int a=map.get(x)/3;
                cnt+=a+1;
            }
        }
        return cnt;
    }
}