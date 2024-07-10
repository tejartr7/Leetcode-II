class Solution {
    public int minOperations(String[] logs) {
        int i,j,n=logs.length;
        Stack<String> stack=new Stack<>();
        for(i=0;i<n;i++){
            String x=logs[i];
            if(x.equals("../")){
                if(!stack.isEmpty())
                stack.pop();
            }
            else if(!x.equals("./")){
                stack.push(x);
            }
        }
        return stack.size();
    }
}