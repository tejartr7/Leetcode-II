class Solution {
    public int maxDepth(String s) {
        int count=0;
        int i,max=0,n=s.length();
        Stack<Character>stack=new Stack<>();
        for(i=0;i<n;i++)
        {
         char ch=s.charAt(i);
         if(ch=='(')
         {
             stack.push(ch);
         }
         else if(ch==')')
         {
             stack.pop();
         }
         max=Math.max(stack.size(),max);

        }
        return max;
    }
}