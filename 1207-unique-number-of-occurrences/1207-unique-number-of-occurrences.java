class Solution {
    public boolean uniqueOccurrences(int[] arr) {
       int cnt[]=new int[2001];
       for(int x:arr)
       {
           cnt[x+1000]+=1;
       } 
       Set<Integer> vis=new HashSet<>();
       for(int x:cnt)
       {
           if(x!=0)
           {
               if(vis.contains(x)) return false;
               vis.add(x);
           }
       } 
       return true;
    }
}