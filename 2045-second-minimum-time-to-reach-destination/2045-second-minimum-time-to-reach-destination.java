class pair{
    int dist;
    int node;
    pair(int a,int b){
        dist=a;
        node=b;
    }
}
class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        int i,j,maxi=1000_000_000;
        int min1[]=new int[n+1];
        int min2[]=new int[n+1];
        Arrays.fill(min1,maxi);
        Arrays.fill(min2,maxi);
        min1[1]=0;
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.offer(new pair(0,1));
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int x[]:edges){
            int a=x[0],b=x[1];
            if(!map.containsKey(a))
                map.put(a,new ArrayList<>());
            if(!map.containsKey(b))
                map.put(b,new ArrayList<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        while(pq.size()>0){
            pair top=pq.poll();
            int dist=top.dist;
            int node=top.node;
            if(node==n && min2[n]!=maxi) return min2[n];
            if((dist/change)%2==1){
                dist=((dist/change)+1)*change;
            }
            for(int x:map.get(node)){
                if(min1[x]>dist+time){
                    min2[x]=min1[x];
                    min1[x]=dist+time;
                    pq.offer(new pair(min1[x],x));
                }
                else if(min2[x]>dist+time && min1[x]!=dist+time){
                    min2[x]=dist+time;
                    pq.offer(new pair(min2[x],x));
                }
            }
        }
        return -1;
    }
}