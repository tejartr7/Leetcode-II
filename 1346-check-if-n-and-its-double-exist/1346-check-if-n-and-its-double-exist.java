class Solution {
    public boolean checkIfExist(int[] arr) {
        int i,j,n=arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int x:arr)
            map.put(x,map.getOrDefault(x,0)+1);
        for(int x:arr){
            if(map.containsKey(2*x) && x!=0) return true;
            if(x==0 && map.get(x)>1) return true;
        }
        return false;
    }
}