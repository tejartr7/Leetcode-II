class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> ans=new Stack<>();
        int i,n=s.length();
        for(i=0;i<n;i++)
        {
            char ch=s.charAt(i);
        
            if(ch==')'){
            if(!ans.isEmpty()  && ans.peek()=='(')
            {
                ans.pop();
            }
                else
                    ans.push(ch);
                }
            else
                ans.push(ch);
        }
        return ans.size();
            
    }
}