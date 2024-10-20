class Solution {
    public boolean parseBoolExpr(String s) {
        int i,j,n=s.length();
        Stack<Character> stack=new Stack<>();
        for(i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch==')'){
                int t=0,f=0;
                char prev='.';
                while(stack.size()>0 && stack.peek()!='('){
                    char top=stack.pop();
                    if(top=='t') t++;
                    else if(top=='f') f++;
                }
                stack.pop(); 
                prev=stack.pop();
                if(prev=='|'){
                    stack.push(t > 0 ? 't' : 'f');
                }
                else if(prev=='&'){
                    stack.push(f > 0 ? 'f' : 't');
                }
                else {
                    stack.push(f > 0 ? 't' : 'f');
                }
            }
            else if(ch=='!' ||ch=='(' || ch=='&' || ch=='|' || ch=='f' || ch=='t'){
                stack.push(ch);
            }
        }
        return stack.peek()=='t';
    }
}