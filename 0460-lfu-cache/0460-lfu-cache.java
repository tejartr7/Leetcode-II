class LFUCache {
    int min;
    int cap;
    int size;
    Map<Integer,LinkedHashMap<Integer,Integer>> freq=new HashMap<>();
    Map<Integer,Integer> key=new HashMap<>();
    Map<Integer,Integer> cnt=new HashMap<>();
    public LFUCache(int capacity) {
        cap=capacity;
        min=0;
        size=0;
        freq.put(1,new LinkedHashMap<>());
    }
    
    public int get(int keyy) {
        if(key.containsKey(keyy))
        {
            updateFreq(keyy);
            return key.get(keyy);
        }
        return -1;
    }
    
    public void put(int keyy, int value) {
        if(cap==0)
            return ;
        if(key.containsKey(keyy))
        {
            key.put(keyy,value);
            updateFreq(keyy);
        }
        else
        {
            size++;
            if(size>cap)
            {
                int temp=-1;
                for(int x:freq.get(min).keySet()){
                    freq.get(min).remove(x);
                    temp=x;
                    break;
                }
                key.remove(temp);
                cnt.remove(temp);
                size--;
            }
            min=1;
            freq.get(1).put(keyy,value);
            cnt.put(keyy,1);
            key.put(keyy,value);
        }
    }
    public void updateFreq(int keyy)
    {
        int f=cnt.get(keyy);
        freq.get(f).remove(keyy);
        if(!freq.containsKey(f+1))
            freq.put(f+1,new LinkedHashMap<>());
        freq.get(f+1).put(keyy,key.get(keyy));
        cnt.put(keyy,f+1);
        while(min==f && freq.get(min).size()==0)
            min++;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */