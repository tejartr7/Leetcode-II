class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int cnt=0;
        ListNode itr=head;
        while(itr!=null){
            cnt++;
            itr=itr.next;
        }
        int eachSize=cnt/k,rem=cnt%k;
        itr=head;
        ListNode[] ans=new ListNode[k];
        ListNode splitHead=new ListNode(-1);
        ListNode splitItr=splitHead;
        int splitSize=0;
        int idx=0;
        while(itr!=null){
            //System.out.println(itr.val);
            if(splitSize==eachSize){
                if(rem>0){
                    rem--;
                    //System.out.println(itr.val);
                    ListNode node=new ListNode(itr.val);
                    splitItr.next=node;
                    splitItr=splitItr.next;
                    itr=itr.next;
                }
                ans[idx++]=splitHead.next;
                splitHead=new ListNode(-1);
                splitSize=0;
                splitItr=splitHead;
            }
            else{
                splitSize++;;
                ListNode node=new ListNode(itr.val);
                splitItr.next=node;
                splitItr=splitItr.next;
                itr=itr.next;
            }
        }
        if(splitHead.next!=null){
            ans[idx]=splitHead.next;
        }
        return ans;
    }
}