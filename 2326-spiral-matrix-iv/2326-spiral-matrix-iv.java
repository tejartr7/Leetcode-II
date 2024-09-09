class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int amin=0,amax=m-1,bmin=0,bmax=n-1;
        List<Integer> list=new ArrayList<>();  
        int a[][]=new int[m][n];
        for(int x[]:a){
            Arrays.fill(x,-1);
        }
        boolean visited[][]=new boolean[amax+1][bmax+1];
        ListNode curr=head;
        while(amin<=amax && bmin<=bmax)
        {
            if(curr==null) break;
            int i,j;
            i=amin;
            for(j=bmin;j<=bmax;j++)
            {   if(!visited[i][j]){
                if(curr==null) break;
                a[i][j]=curr.val;
                curr=curr.next;
                visited[i][j]=true;
            }
            }
            amin++;
            j=bmax;
            for(i=amin;i<=amax;i++)
            {
               if(!visited[i][j]){
                if(curr==null) break;
                a[i][j]=curr.val;
                curr=curr.next;
                visited[i][j]=true;
            }
            }
            bmax--;
            i=amax;
            for(j=bmax;j>=bmin;j--)
            {
                if(!visited[i][j]){
                if(curr==null) break;
                a[i][j]=curr.val;
                curr=curr.next;
                visited[i][j]=true;
            }
            }
            amax--;
            j=bmin;
            for(i=amax;i>=amin;i--)
            {
                if(!visited[i][j]){
                if(curr==null) break;
                a[i][j]=curr.val;
                curr=curr.next;
                visited[i][j]=true;
            }
            }
            bmin++;
        }
        return a;
    }
}