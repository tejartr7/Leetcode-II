class pair{
    int x,y;
    pair(int a,int b){
        x=a;
        y=b;
    }
}
class Solution {
    public int[] getFinalState(int[] nums, int k, int x) {
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.x!=b.x?a.x-b.x:a.y-b.y);
        int i,j,n=nums.length;
        for(i=0;i<n;i++){
            pq.offer(new pair(nums[i],i));
        }
        while(k>0){
            pair top=pq.poll();
            pq.offer(new pair(top.x*x,top.y));
            k--;
        }
        int ans[]=new int[n];
        while(pq.size()>0){
            pair top=pq.poll();
            ans[top.y]=top.x;
        }
        return ans;
    }
}