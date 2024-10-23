class Solution {
    Map<TreeNode,Integer> map;
    public TreeNode replaceValueInTree(TreeNode root) {
        map=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        List<Integer> list=new ArrayList<>();
        while(q.size()>0){
            int i,j,n=q.size();
            int sum=0;
            for(i=0;i<n;i++){
                TreeNode top=q.poll();
                int val=0;
                sum+=top.val;
                if(top.left!=null){
                    val+=top.left.val;
                    q.offer(top.left);
                }
                if(top.right!=null){
                    val+=top.right.val;
                    q.offer(top.right);
                }
                if(top.left!=null)
                map.put(top.left,val);
                if(top.right!=null)
                map.put(top.right,val);
            }
            list.add(sum);
        }
        
        System.out.println(list);
        int lvl=0;
        q.offer(root);
        while(q.size()>0){
            int i,j,n=q.size();
            for(i=0;i<n;i++){
                TreeNode top=q.poll();
                int sum=list.get(lvl)-map.getOrDefault(top,top.val);
                top.val=sum;
                if(top.left!=null){
                    q.offer(top.left);
                }
                if(top.right!=null){
                    q.offer(top.right);
                }
            }
            lvl++;
        }
        return root;
    }
}