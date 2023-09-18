import java.util.PriorityQueue;

import javax.print.attribute.standard.PageRanges;

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)->(a[0]!=b[0]?b[0]-a[0]:b[1]-a[1]));
        int i,n=mat.length;
        int j;
        for(i=0;i<n;i++)
        {
            int count=0;
            int len=mat[i].length;
            for(j=0;j<len;j++)
            {
                if(mat[i][j]==1)
                count++;
                else
                    break;
            }
            pq.offer(new int[]{count,i});
        }
        while(pq.size()>k)
        pq.poll();
        int ans[]=new int[k];
        i=0;
        while(k>0)
        {
            ans[--k]=pq.poll()[1];
        }
        return ans;
    }
}