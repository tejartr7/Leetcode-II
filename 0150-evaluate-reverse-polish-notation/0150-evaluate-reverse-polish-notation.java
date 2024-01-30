class Solution {
    public int evalRPN(String[] t) {
        int i,n=t.length;
        Stack<Integer> ans=new Stack<>();
        for(i=0;i<n;i++)
        {   String p=t[i];
            if(ans.isEmpty())
            {
                ans.push(Integer.valueOf(p));
            }
            else if(p.equals("+") )
            {
                int a=ans.pop();
                int b=ans.pop();
                int c=a+b;
                ans.push(c);
            }
           else if(p.equals("-") )
            {
                int a=ans.pop();
                int b=ans.pop();
                int c=b-a;
                ans.push(c);
            }
           else if(p.equals("*") )
            {
                int a=ans.pop();
                int b=ans.pop();
                int c=a*b;
                ans.push(c);
            }  else if(p.equals("/") )
            {
                int a=ans.pop();
                int b=ans.pop();
                int c=b/a;
                ans.push(c);
            }
         else
             ans.push(Integer.valueOf(p));
        }
        return ans.peek();
    }
}