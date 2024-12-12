class Solution {
    public long pickGifts(int[] gifts, int k) {
        long ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int x:gifts)
            pq.offer(x);
        while(k-->0){
            int top=pq.poll();
            int sqrt=(int)Math.sqrt(top);
            pq.offer(sqrt);
        }
        while(pq.size()>0){
            ans+=pq.poll();
        }
        return ans;
    }
}