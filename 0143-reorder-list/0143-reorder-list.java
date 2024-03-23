/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void printer(ListNode head)
    {
        while(head!=null)
        {
            System.out.print(head.val+" ");
            head=head.next;
        }
    }
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
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode next=slow.next;
        slow.next=null;
        //System.out.println(next.val);
        ListNode rev=reverseList(next);
        //printer(rev);
        ListNode curr=head;
        ListNode traverse=head;
        while(curr!=null && rev!=null)
        {
            ListNode n1=curr.next;
            ListNode n2=rev.next;
            if(traverse==curr)
            {
                traverse.next=rev;
                traverse=rev;
                curr=n1;
            }
            else if(traverse==rev) {
                traverse.next=curr;
                traverse=curr;
                rev=n2;
            }
        }
    }
}