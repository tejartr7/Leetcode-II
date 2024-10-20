class Solution {
    public boolean parseBoolExpr(String s) {
        boolean ans=true;
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
                if(stack.size()>0 && stack.peek()=='(')
                stack.pop();
                if(stack.size()>0){
                    prev=stack.pop();
                }
                if(prev=='|'){
                    if(t>0){
                        stack.push('t');
                    }
                    else stack.push('f');
                }
                else if(prev=='&'){
                    if(f>0){
                        stack.push('f');
                    }
                    else stack.push('t');
                }
                else if(prev=='!'){
                    if(t>0){
                        stack.push('f');
                    }
                    else stack.push('t');
                }
            }
            else if(ch=='!' ||ch=='(' || ch=='&' || ch=='|' || ch=='f' || ch=='t'){
                stack.push(ch);
            }
            //System.out.println(stack);
        }
        if(stack.size()>0){
            return stack.peek()=='t';
        }
        
        return false;
    }
}