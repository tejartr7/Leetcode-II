

class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        if (n == 0)
            return tasks.length;
        int i,l=tasks.length;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int a[]=new int[26];
        for(char x:tasks)
            a[x-'A']++;
        for(i=0;i<26;i++)
        {
            if(a[i]>0)
                pq.offer(a[i]);
        }
        int t=0;
        
        
        while((!pq.isEmpty() || !q.isEmpty()))
        {
            t++;
            if(pq.size()>0)
            {
                int x=pq.poll();
                x--;
                if(x>0)
                    q.offer(new Pair(x,t+n));
            }
            if (!q.isEmpty() && q.peek().getValue() == t) pq.add(
                q.poll().getKey()
            );
        }
        return t;
    }
}