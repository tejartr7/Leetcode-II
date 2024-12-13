class pair{
    int x,y;
    pair(int a,int b){
        x=a;
        y=b;
    }
}
class Solution {
    public long findScore(int[] nums) {
        long ans=0;
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.x!=b.x?a.x-b.x:a.y-b.y);
        int i,j,n=nums.length;
        for(i=0;i<n;i++){
            pq.offer(new pair(nums[i],i));
        }
        Set<Integer> vis=new HashSet<>();
        while(pq.size()>0){
            pair top=pq.poll();
            if(vis.contains(top.y))
            continue;
            ans+=top.x;
            vis.add(top.y);
            vis.add(top.y-1);
            vis.add(top.y+1);
        }
        return ans;
    }
}