class Solution {
    public void deleteNode(ListNode node) {
        if(node.next!=null)
        {
           int k=node.next.val;
           node.next=node.next.next;
           node.val=k;
        }
    }
}