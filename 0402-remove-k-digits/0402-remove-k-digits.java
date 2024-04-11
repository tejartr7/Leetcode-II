class Solution {
    public String removeKdigits(String num, int k) {
        String ans="";
        Stack<Character> stack=new Stack<>();
        int i,n=num.length();
        int x=k;
        if(n==k)
        return "0";
        for(i=0;i<n;i++)
        {
            char ch=num.charAt(i);
            if(stack.isEmpty())
            {
                stack.push(num.charAt(i));
            }
            else
            {
                while(!stack.isEmpty() && stack.peek()>ch && k>0)
                {
                    stack.pop();
                    k--;
                }
                stack.push(num.charAt(i));
            }
        }
        while(!stack.isEmpty() && k >0){
            stack.pop();
            k--;
        }
        k=x;
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            char c = stack.pop();
            sb.append(c);
        }
        sb.reverse();
        
        //Remove trailing zeros if any
        while(sb.length() >1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}