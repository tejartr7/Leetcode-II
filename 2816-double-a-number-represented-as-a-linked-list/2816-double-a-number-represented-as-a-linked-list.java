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
    public ListNode helper(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
       
        if (p != null) p = p.next;
        if (q != null) q = q.next;
         curr = curr.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}
    public ListNode doubleIt(ListNode head) {
        if(head==null)
            return head;
        ListNode rev=reverseList(head);
        int c=0;
        ListNode temp=new ListNode(-1);
       
        return reverseList(helper(rev,rev));
    }
}