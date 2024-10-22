

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<List<Integer>> list = new LinkedList<List<Integer>>();

    public void dfs(TreeNode root, int level) {
        if (root == null)
            return;
        if (list.size() < level)
            list.add(new ArrayList<Integer>());
        list.get(level - 1).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null)
            return list;
        dfs(root, 1);
        return list;
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        //List<List<Integer>> list = levelOrder(root);
        Queue <TreeNode> q = new ArrayDeque<TreeNode>();
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        q.offer(root);
       while(!q.isEmpty()) {
        int num = q.size();
           long sum=0;
        //List<Integer> subList = new ArrayList<Integer>();
        for(int i = 0; i < num; i ++) {
          if(q.peek().left != null)
            q.offer(q.peek().left);
           if(q.peek().right != null)
            q.offer(q.peek().right);
          sum+=q.poll().val;
        }
           pq.offer(sum);
        //list.add(subList);
      }
        if (pq.size()<k)
            return -1;
        while(k>1)
        {
            pq.poll();
            k--;
        }
        return pq.peek();
    }
}