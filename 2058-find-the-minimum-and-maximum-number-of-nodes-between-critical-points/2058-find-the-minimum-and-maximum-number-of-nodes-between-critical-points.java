class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int i,j;
        int ans[]=new int[2];
        int cnt=1,p=-1;
        int f=-1;
        ans[0]=1000_000_000;
        ans[1]=0;
        ListNode prev=head;
        ListNode curr=head.next;
        if(head==null || head.next==null ||curr.next==null)
            return new int[]{-1,-1};
        while(curr!=null){
            if(curr.val>prev.val && curr.next!=null){
                if(curr.next.val<curr.val){
                    if(f==-1){
                        f=cnt;
                    }
                    if(p!=-1)
                    ans[0]=Math.min(ans[0],cnt-p);
                    if(f!=-1)
                        ans[1]=Math.max(ans[1],cnt-f);
                    p=cnt;
                }
            }
            else if(curr.val<prev.val && curr.next!=null){
                if(curr.next.val>curr.val){
                    if(f==-1){
                        f=cnt;
                    }
                    if(p!=-1)
                        ans[0]=Math.min(ans[0],cnt-p);
                    if(f!=-1)
                        ans[1]=Math.max(ans[1],cnt-f);
                    p=cnt;
                }
            }
            prev=curr;
            curr=curr.next;
            cnt++;
        }
        ans[0]=ans[0]==1000_000_000?-1:ans[0];
        ans[1]=ans[1]==0?-1:ans[1];
        return ans;
    }
}