class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        
        TreeNode res = null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            res = queue.peek();
            for(int i = 0; i < size; i++){
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.offer(temp.left);
                if(temp.right != null) queue.offer(temp.right);
            }
        }
        
        return res.val;
    }
}