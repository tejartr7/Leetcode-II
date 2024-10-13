class Solution {
    List<Integer> list=new ArrayList<>();
    public boolean helper(TreeNode root, int size[]) {
    if (root == null) {
        size[0] = 0; // No nodes if the root is null
        return true;
    }
    
    int[] leftSize = new int[1];
    int[] rightSize = new int[1];
    
    boolean isLeftPerfect = helper(root.left, leftSize);
    boolean isRightPerfect = helper(root.right, rightSize);
    
    // Check if both left and right subtrees are perfect and have the same size
    if (isLeftPerfect && isRightPerfect && leftSize[0] == rightSize[0]) {
        size[0] = 1 + leftSize[0] + rightSize[0]; // Current size is 1 (current node) + sizes of left and right subtrees
        list.add(size[0]);
        return true;
    } else {
        return false; 
    }
    }

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        helper(root,new int[1]);
        Collections.sort(list,Collections.reverseOrder());
        if(list.size()<k){
            return -1;
        }
        return list.get(k-1);
    }
}