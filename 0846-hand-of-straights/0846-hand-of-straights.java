class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        int i,j,n=hand.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int x:hand){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(i=0;i<n;i++){
            int x=hand[i];
            if(map.containsKey(x)){
                for(j=x;j<x+groupSize;j++){
                    if(map.containsKey(j)){
                        map.put(j,map.get(j)-1);
                        if(map.get(j)==0)
                            map.remove(j);
                    }
                    else return false;
                }
            }
        }
        return true;
    }
}