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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count=0;
        ListNode curr=head;
        while(curr!=null)
        {
            count++;
            curr=curr.next;
        }
        if(count==n)
            return head.next;
        curr=head;
        int x=0;
        while(x<count-n-1)
        {
            curr=curr.next;
            x++;
            
        }
        ListNode k=curr.next;
        if(k!=null)
        curr.next=k.next;
        else
            curr.next=null;
        
        return head;
    }
}