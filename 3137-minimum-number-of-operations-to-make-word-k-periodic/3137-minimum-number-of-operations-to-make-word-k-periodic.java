class Solution {
    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int i,j,n=word.length();
        Map<String,Integer> map=new HashMap<>();
        for(i=0;i<n;i+=k){
            String temp=word.substring(i,i+k);
            map.put(temp,map.getOrDefault(temp,0)+1);
        }
        //System.out.println(map);
        int maxi=0;
        for(String x:map.keySet()){
            maxi=Math.max(maxi,map.get(x));
        }
        return n/k-maxi;
    }
}