class Solution {
    public int findSpecialInteger(int[] arr) {
        int i,j,n=arr.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int x:arr) map.put(x,map.getOrDefault(x,0)+1);
        for(int x:map.keySet())
            if(map.get(x)>n/4)
                return x;
        return -1;
    }
}