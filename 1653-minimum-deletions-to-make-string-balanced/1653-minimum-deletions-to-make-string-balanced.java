class Solution {
    public int minimumDeletions(String s) {
        int i,j,n=s.length();
        Stack<Character> stack=new Stack<>();
        int ans=0;
        for(i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='a'){
                if(stack.size()>0 && stack.peek()=='b'){
                    ans++;
                    stack.pop();
                }
            }
            else stack.push(ch);
        }
        return ans;
    }
}