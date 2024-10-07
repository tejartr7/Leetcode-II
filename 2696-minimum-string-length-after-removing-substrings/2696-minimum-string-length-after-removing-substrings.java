class Solution {
    public int minLength(String s) {
        int i,j,n=s.length();
        Stack<Integer> stack=new Stack<>();
        for(i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='B'){
                if(!stack.isEmpty()){
                    if(s.charAt(stack.peek())=='A'){
                        stack.pop();
                    }
                    else stack.push(i);
                }
                else stack.push(i);
            }
            else if(ch=='D'){
                if(!stack.isEmpty()){
                    if(s.charAt(stack.peek())=='C'){
                        stack.pop();
                    }
                    else stack.push(i);
                }
                else stack.push(i);
            }
            else
            stack.push(i);
        }
        return stack.size();
    }
}