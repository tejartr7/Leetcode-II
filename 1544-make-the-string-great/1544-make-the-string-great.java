class Solution {
    public String makeGood(String s) {
        String p="";
        int i,n=s.length();
        Stack<Character> ans=new Stack<>();
        for(i=0;i<n;i++)
        {   char ch=s.charAt(i);
           
            if(!ans.isEmpty() && ch+32==ans.peek() || (!ans.isEmpty() &&ch-32==ans.peek()))
            {
                ans.pop();
            }
           else
             ans.push(ch);
         }
        while(!ans.isEmpty())
        {
            p=String.valueOf(ans.pop())+p;
        }
        return p;
    }
}