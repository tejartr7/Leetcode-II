class Solution {
    List<Integer> list;
    public void inorder(TreeNode root){
        if(root==null) return ;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public TreeNode creator(List<Integer> list,int s,int e){
        int mid=(s+e)/2;
        if(s>e) return null;
        if(s==e)return new TreeNode(list.get(s));
        TreeNode root=new TreeNode(list.get(mid));
        root.left=creator(list,s,mid-1);
        root.right=creator(list,mid+1,e);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        list=new ArrayList<>();
        inorder(root);
        int n=list.size();
        return creator(list,0,n-1);
    }
}