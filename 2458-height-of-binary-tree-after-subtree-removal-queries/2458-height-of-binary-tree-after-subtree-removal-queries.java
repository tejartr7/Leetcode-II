class Solution {
    int lvl[];
    int h[];
    int max1[];
    int max2[];

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int x = helper(root.left);
        int y = helper(root.right);
        h[root.val] = Math.max(x, y) + 1;
        return h[root.val];
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        lvl = new int[100001];
        h = new int[100001];
        max1 = new int[100001];
        max2 = new int[100001];
        
        int ql = queries.length;
        int ans[] = new int[ql];
        
        Queue<TreeNode> q = new LinkedList<>();
        helper(root);
        
        q.offer(root);
        int x = 0;
        
        while (q.size() > 0) {
            int m1 = 0, m2 = 0;
            int l = q.size();
            
            for (int i = 0; i < l; i++) {
                TreeNode top = q.poll();
                lvl[top.val] = x;

                if (h[top.val] > m1) {
                    m2 = m1;
                    m1 = h[top.val];
                } else if (h[top.val] > m2) {
                    m2 = h[top.val];
                }

                if (top.left != null) q.offer(top.left);
                if (top.right != null) q.offer(top.right);
            }

            max1[x] = m1;
            max2[x] = m2;
            x++;
        }

        for (int i = 0; i < ql; i++) {
            int queryNode = queries[i];
            int l = lvl[queryNode];
            int height = h[queryNode];
            int temp = max1[l];
            
            if (height == max1[l]) {
                temp = max2[l];
            }

            ans[i] = l + temp - 1;
        }
        
        return ans;
    }
}
