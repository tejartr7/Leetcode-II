
class pair
{
    TreeNode root;
    int lvl;
    pair(TreeNode x,int cnt)
    {
        root=x;
        lvl=cnt;
    }
}
class Solution {
    TreeNode temp=null;
    public void inorder(TreeNode root,int x,Map<TreeNode,TreeNode> map)
    {
        if(root==null) return ;
        if(root.val==x)
            temp=root;
        if(root.left!=null)
            map.put(root.left,root);
        if(root.right!=null)
            map.put(root.right,root);
        inorder(root.left,x,map);
        inorder(root.right,x,map);
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode,TreeNode> map=new HashMap<>();
        if(root==null) return 0;
        inorder(root,start,map);
        //System.out.println(map);
        int ans=0;
        Queue<pair> q=new LinkedList<>();
        if(temp==null) return 0;
        q.offer(new pair(temp,0));
        Set<Integer> set=new HashSet<>();
        int maxi=0;
        while(!q.isEmpty())
        {
            pair top=q.poll();
            if(set.contains(top.root.val))
                continue;
            maxi=Math.max(maxi,top.lvl);
            set.add(top.root.val);
            if(map.containsKey(top.root))
                q.offer(new pair(map.get(top.root),top.lvl+1));
            if(top.root.left!=null)
                q.offer(new pair(top.root.left,top.lvl+1));
            if(top.root.right!=null)
                q.offer(new pair(top.root.right,top.lvl+1));
        }
        return maxi;
    }
}