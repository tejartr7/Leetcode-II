class Solution {
    public TreeNode lca(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q)
            return root;
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if (left == null)
            return right;
        if (right == null)
            return left;
        return root;
    }

    private boolean dfs(TreeNode root, int target, StringBuilder path) {
        if (root == null)
            return false;
        if (root.val == target)
            return true;
        path.append('L');
        if (dfs(root.left, target, path))
            return true;
        path.setLength(path.length() - 1); // backtrack

        path.append('R');
        if (dfs(root.right, target, path))
            return true;
        path.setLength(path.length() - 1); // backtrack

        return false;
    }

    public String getDirections(TreeNode root, int x, int y) {
        TreeNode lcaNode = lca(root, x, y);

        StringBuilder path1 = new StringBuilder();
        dfs(lcaNode, x, path1);
        
        StringBuilder path2 = new StringBuilder();
        dfs(lcaNode, y, path2);

        // Replace all characters in path1 with 'U'
        for (int i = 0; i < path1.length(); i++) {
            path1.setCharAt(i, 'U');
        }

        return path1.toString() + path2.toString();
    }
}
