class Solution {
    public List<List<Integer>> groupThePeople(int[] a) {
        List<List<Integer>> ans=new ArrayList<>();
        Map<Integer,ArrayList<Integer>> map=new HashMap<>();
        int i,n=a.length;
        for(i=0;i<n;i++)
        {
            if(!map.containsKey(a[i]))
            map.put(a[i],new ArrayList<>());
            map.get(a[i]).add(i);
        }
        for(int x:map.keySet())
        {
            List<Integer> list=map.get(x);
            int cnt=0;
            List<Integer> temp=new ArrayList<>();
            while(cnt<list.size())
            {
                if(cnt>0 && cnt%x==0)
                {
                    ans.add(new ArrayList<>(temp));
                    temp.clear();
                }
                temp.add(list.get(cnt));
                cnt++;
            }
            if(cnt>0 && cnt%x==0)
            {
                ans.add(new ArrayList<>(temp));
                temp.clear();
            }
        }
        return ans;
    }
}