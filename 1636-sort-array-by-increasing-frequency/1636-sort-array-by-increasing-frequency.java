class pair{
    int x,y;
    pair(int a,int b){
        x=a;
        y=b;
    }
}
class Solution {
    public int[] frequencySort(int[] nums) {
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.y!=b.y?a.y-b.y:b.x-a.x);
        int i,j,n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        for(int x:map.keySet()){
            pq.offer(new pair(x,map.get(x)));
        }
        i=0;
        while(pq.size()>0){
            pair top=pq.poll();
            int temp=top.y;
            while(temp>0){
                nums[i++]=top.x;
                temp--;
            }
        }
        return nums;
    }
}