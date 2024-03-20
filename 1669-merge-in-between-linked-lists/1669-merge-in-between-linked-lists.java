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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        if(list2==null) return list1;
        ListNode curr=list1;
        ListNode temp1=null,temp2=null;
        int cnt=0;
        while(curr!=null){
            if(cnt==a-1){
                temp1=curr;
            }
            if(cnt==b+1)
            {
                temp2=curr;
            }
            curr=curr.next;
            cnt++;
        }
        temp1.next=list2;
        while(list2.next!=null)
        {
            list2=list2.next;
        }
        list2.next=temp2;
        return list1;
    }
}