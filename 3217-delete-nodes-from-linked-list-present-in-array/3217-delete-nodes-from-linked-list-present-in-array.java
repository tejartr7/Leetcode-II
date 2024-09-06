class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        int i,j,n=nums.length;
        Set<Integer> set=new HashSet<>();
        for(int x:nums) set.add(x);
        ListNode temp=new ListNode(-1);
        ListNode curr=head;
        ListNode x=temp;
        while(curr!=null){
            if(!set.contains(curr.val)){
                ListNode temp2=new ListNode(curr.val);
                x.next=temp2;
                x=x.next;
            }
            curr=curr.next;
        }
        return temp.next;
    }
}