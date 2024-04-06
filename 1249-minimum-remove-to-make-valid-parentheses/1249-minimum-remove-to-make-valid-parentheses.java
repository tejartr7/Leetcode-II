class Solution {
    public String minRemoveToMakeValid(String s) {
        int i,j,n = s.length();
        char ch[] = new char[n];
        Arrays.fill(ch,'x');
        Stack<Integer> stack = new Stack<>();
        for(i=0;i<n;i++)
        {
            char c = s.charAt(i);
            if(c!='(' && c!=')')
            {
                ch[i] = '.';
            }
            else if(c == ')')
            {
                if(!stack.isEmpty())
                {
                    if(s.charAt(stack.peek())=='(')
                    {
                        ch[stack.peek()] = ch[i] = '.';
                        stack.pop();
                    }
                }
            }
            else{
                stack.push(i);
            }
        }
        String ans="";
        for(i=0;i<n;i++)
        {
            if(ch[i]=='.')
                ans+=s.charAt(i);
        }
        return ans;
    }
}