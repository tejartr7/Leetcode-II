class Solution {
    int ans=0;
    public void helper(TreeNode root,int[] arr)
    {
        if(root==null) return ;
        arr[root.val]++;
        int temp[]=arr.clone();
        if(root.left==null && root.right==null)
        {
            int odd=0;
            for(int i=1;i<10;i++)
            {
                if(arr[i]%2==1)
                    odd++;
            }
            if(odd<=1)
                ans++;
            return ;
        }
        helper(root.left,arr);
        arr=temp.clone();
        helper(root.right,arr);
        //arr[root.val]--;
    }
    public int pseudoPalindromicPaths (TreeNode root) {
        ans=0;
        helper(root,new int[10]);
        return ans;
    }
}