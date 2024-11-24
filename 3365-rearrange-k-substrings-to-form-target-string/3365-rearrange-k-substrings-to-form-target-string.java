class Solution {
    public boolean isPossibleToRearrange(String s, String t, int k) {
        int i,j,m=s.length(),n=t.length();
        Map<String,Integer> map=new HashMap<>();
        for(i=0;i<n;i+=n/k){
            String temp=s.substring(i,i+n/k);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        for(i=0;i<n;i+=n/k){
            String temp=t.substring(i,i+n/k);
            if(!map.containsKey(temp)) return false;
            map.put(temp,map.get(temp)-1);
            if(map.get(temp)==0) map.remove(temp);
        }
        return true;
    }
}