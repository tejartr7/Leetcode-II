
class Solution {
    public void dfs(Node node,Node copy,Node[] vis)
    {
        vis[copy.val]=copy;
        System.out.println(copy.val);
        for(Node x:node.neighbors)
        {
            if(vis[x.val]==null)
            {
                Node temp=new Node(x.val);
                copy.neighbors.add(temp);
                dfs(x,temp,vis);
            }
            else {
                copy.neighbors.add(vis[x.val]);
            }
        }
    }
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        System.out.println(node+" "+node.val);
        Node copy=new Node(node.val);
        Node[] vis=new Node[101];
        dfs(node,copy,vis);
        return copy;
    }
}