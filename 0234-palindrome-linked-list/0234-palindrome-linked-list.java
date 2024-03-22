class Solution {
   private ListNode reverse(ListNode a)
    { 
        ListNode curr=a;
        ListNode temp=null;
        ListNode prev=null;
        while(curr!=null)
        {
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
     return prev;
    }
    private ListNode mid(ListNode k)
    {
        ListNode a=k;
        ListNode b=k;
        while( a!=null &&a.next!=null)
        {
            a=a.next.next;
            b=b.next;
        }
        return b;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode b=head;
        ListNode curr=mid(b);
        ListNode p=reverse(curr);
        ListNode a=head;
        while(p!=null)
        {
            if(p.val!=a.val)
                return false;
            p=p.next;
            a=a.next;
        }
        return true;
    }
}