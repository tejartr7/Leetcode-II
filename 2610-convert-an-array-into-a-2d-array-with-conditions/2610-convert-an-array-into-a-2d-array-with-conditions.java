class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> temp=new ArrayList<>();
        int i,j,n=nums.length;
        for(i=0;i<n;i++)
            temp.add(new ArrayList<>());
        Map<Integer,Integer> map=new HashMap<>();
        for(int x:nums)
            map.put(x,map.getOrDefault(x,0)+1);
        for(int x:map.keySet())
        {
            int idx=0;
            int cnt=map.get(x);
            while(cnt>0)
            {
                temp.get(idx).add(x);
                cnt--;
                idx++;
            }
        }
        List<List<Integer>> list=new ArrayList<>();
        for(List<Integer> x:temp)
        {
            if(x.size()==0)
                return list;
            list.add(new ArrayList<>(x));
        }
        return list;
    }
}