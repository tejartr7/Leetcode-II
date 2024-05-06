class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr=head,prev=null;
        while(curr!=null)
        {   ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
       ListNode t=reverseList(head);
       ListNode temp=t;
       while(t!=null)
       {
           while(t.next!=null && t.next.val<t.val)
           {
               t.next=t.next.next;
           }
           t=t.next;
       }
       return reverseList(temp);
    }
}