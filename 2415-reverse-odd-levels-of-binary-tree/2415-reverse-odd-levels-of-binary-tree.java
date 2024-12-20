
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int lvl=0;
        while(!q.isEmpty()){
            int size = q.size();
            List<TreeNode> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                list.add(curr);
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(lvl%2==1){
                int i=0,j=list.size()-1;
                while(i<j){
                    int temp = list.get(i).val;
                    TreeNode a= list.get(i);
                    TreeNode b= list.get(j);
                    a.val=b.val;
                    b.val=temp;
                    i++;
                    j--;
                }
            }
            lvl++;
        }
        return root;        
    }
}