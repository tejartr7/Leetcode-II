class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> list=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        String temp1[]=s1.split(" ");
        String temp2[]=s2.split(" ");
        for(String x:temp1) map.put(x,map.getOrDefault(x,0)+1);
        for(String x:temp2) map.put(x,map.getOrDefault(x,0)+1);
        for(String x:map.keySet()){
          if(map.get(x)==1){
            list.add(x);
          }
        }
        return list.toArray(new String[list.size()]);
    }
}