class Solution {
    public boolean find132pattern(int[] nums) {
        int i,j,n=nums.length;
        Stack<Integer> stack=new Stack<>();
        int[] mini=new int[n];
        mini[0]=nums[0];
        for(i=1;i<n;i++)
            mini[i]=Math.min(mini[i-1],nums[i]);
        for(i=n-1;i>=0;i--)
        {
            if(nums[i]>mini[i])
            {
                while(!stack.isEmpty() && stack.peek()<=mini[i])
                {
                    stack.pop();
                }
                if(!stack.isEmpty() && nums[i]>stack.peek())
                    return true;
                stack.push(nums[i]);
            }
        }
        return false;
    }
}