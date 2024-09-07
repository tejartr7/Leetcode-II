class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head==null) return true;
        if(root==null) return false;
        return helper(head,root) || isSubPath(head,root.left) ||
            isSubPath(head,root.right);
    }
    public boolean helper(ListNode head,TreeNode root){
        if(head==null) return true;
        if(root==null) return false;
        if(head.val==root.val){
            return helper(head.next,root.right) ||
                helper(head.next,root.left);
        }
        return false;
    }
}