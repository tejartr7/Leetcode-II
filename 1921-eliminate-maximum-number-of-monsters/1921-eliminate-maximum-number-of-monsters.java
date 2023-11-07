class pair
{
    int val;
    int idx;
    pair(int a,int b)
    {
        val=a;
        idx=b;
    }
}
class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int cnt=0;
        int i,j,n=dist.length;
        for(i=0;i<n;i++)
        {
            int temp=dist[i]/speed[i];
            if(dist[i]%speed[i]!=0)
                temp++;
            pq.offer(temp);
        }
        for(i=0;i<n;i++)
        {
            if(pq.peek()-cnt>0)
            {
                cnt++;
                pq.poll();
            }
            else break;
        }
        return cnt;
    }
}