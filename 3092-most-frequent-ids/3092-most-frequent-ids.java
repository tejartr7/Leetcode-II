class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        Map<Long,Long> map=new HashMap<>();
       TreeMap<Long, Long> tmap = new TreeMap<>(Collections.reverseOrder());
        int i,j,n=nums.length;
        long ans[]=new long[n];
        for(i=0;i<n;i++)
        {
            long x=nums[i];
            long y=freq[i];
            
            if(y>0)
            {
                if(!map.containsKey(x)){
                map.put(x,y);
                tmap.put(y,tmap.getOrDefault(y,0l)+1l);
                }
                else{
                    long temp=map.get(x);
                    long key=temp+freq[i];
                    tmap.put(temp,tmap.getOrDefault(temp,0l)-1l);
                    if(tmap.get(temp)==0l) tmap.remove(temp);
                    tmap.put(key,tmap.getOrDefault(key,0l)+1l);
                    map.put(x,map.get(x)+y);
                }
            }
            else{
                long temp=map.get(x);
                long key=temp+freq[i];
                map.put(x,map.getOrDefault(x,0l)+freq[i]);
                //System.out.println(temp);
                tmap.put(temp,tmap.getOrDefault(temp,0l)-1l);
                if(tmap.get(temp)==0l) tmap.remove(temp);
                tmap.put(key,tmap.getOrDefault(key,0l)+1l);
            }
            //System.out.println(map);
            //System.out.println(tmap);
            ans[i]=tmap.firstKey();
        }
        return ans;
    }
}