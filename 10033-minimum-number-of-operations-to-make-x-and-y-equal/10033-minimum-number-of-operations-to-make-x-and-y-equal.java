class pair{
    int x,steps;
    pair(int a,int b)
    {
        x=a;
        steps=b;
    }
}
class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        int ans=0;
        if(y>=x)
            return y-x;
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.steps-b.steps);
        pq.offer(new pair(y,0));
        Set<Integer> vis=new HashSet<>();
        int temp=x+x-y;
        vis.add(y);
        while(pq.size()>0)
        {
            pair top=pq.poll();
            int steps=top.steps;
            //System.out.println(top.x+" "+steps);
            if(top.x==x)
                return top.steps;
            if(vis.contains(x) || temp<top.x)
                continue;
            vis.add(top.x);
            if(!vis.contains(top.x*5))
            pq.offer(new pair(top.x*5,steps+1));
            if(!vis.contains(top.x*11))
            pq.offer(new pair(top.x*11,steps+1));
            if(!vis.contains(top.x-1))
            pq.offer(new pair(top.x-1,steps+1));
            if(!vis.contains(top.x+1))
            pq.offer(new pair(top.x+1,steps+1));
        }
        return Math.abs(x-y);
    }
}
