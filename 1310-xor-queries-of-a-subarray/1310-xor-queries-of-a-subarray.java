class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int i,j,n=arr.length,q=queries.length;
        int pre[]=new int[n];
        int ans[]=new int[q];
        pre[0]=arr[0];
        for(i=1;i<n;i++)
        {
            pre[i]=pre[i-1]^arr[i];
        }
        for(i=0;i<q;i++)
        {
            int x=queries[i][0];
            int y=queries[i][1];
            int prev=0;
            if(x-1>=0)
                prev=pre[x-1];
            ans[i]=pre[y]^prev;
        }
        return ans;
    }
}