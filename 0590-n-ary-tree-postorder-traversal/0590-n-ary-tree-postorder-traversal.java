class Solution {
    List<Integer> list;
    public void helper(Node root){
        if(root==null) return ;
        for(Node x:root.children){
            helper(x);
        }
        list.add(root.val);
    }
    public List<Integer> postorder(Node root) {
        list=new ArrayList<>();
        helper(root);
        return list;
    }
}