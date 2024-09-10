class Solution {
    public int gcd(int a,int b)
    {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr=head;
        if(head==null || head.next==null)
            return head;
        ListNode ans=new ListNode(-1);
        ListNode temp=ans;
        while(curr!=null && curr.next!=null)
        {
            int x=curr.val;
            int y=curr.next.val;
            int z=gcd(x,y);
            temp.next=new ListNode(x);
            temp=temp.next;
            temp.next=new ListNode(z);
            temp=temp.next;
            curr=curr.next;
        }
        temp.next=new ListNode(curr.val);
        temp=temp.next;
        return ans.next;
    }
}